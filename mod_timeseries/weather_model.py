# coding=gbk

import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import statsmodels.api as sm

from mod_timeseries.file_transfer import SendFile
from mod_timeseries.process_json import format_json


class ProcessData(object):
    def __init__(self,data,predict_year,data_type):
        self.data = data
        self.predict_year = predict_year
        self.data_type = data_type

    def process_minmax(self):
        if self.data_type == 'max':
            max_data = self.data['tmax']
        elif self.data_type == 'min':
            max_data = self.data['tmin']
        data_year = self.data['date']
        begin_year = data_year[0:1].dt.year
        end_year = data_year[-1:].dt.year
        predict_month = data_year[0:1].dt.month
        predict_day = data_year[0:1].dt.day
        max_data = np.array(max_data, dtype = np.float)

        #转换为一维数组
        max_data = pd.Series(max_data)
        max_data.index = pd.Index(sm.tsa.datetools.dates_from_range(str(begin_year.values[0]), str(end_year.values[0])))
        arma_mod76 = sm.tsa.ARMA(max_data, (7, 6)).fit()
        predict_end_year = end_year.values[0] + self.predict_year
        predict_dta = arma_mod76.predict(str(end_year.values[0]), str(predict_end_year), dynamic = True)
        print(predict_dta)
        predict_dta.to_json(self.data_type+'.json',date_format = 'iso')
        json_date = format_json(self.data_type+'.json',str(predict_month.values[0]), str(predict_day.values[0]))
        print(json_date)
        fig, ax = plt.subplots(figsize=(12,8))
        ax = max_data.loc[str(begin_year.values[0]):].plot(ax=ax)
        arma_mod76.plot_predict(str(end_year.values[0]), str(predict_end_year), dynamic = True, ax = ax, plot_insample = False)

        #fig = plot.gcf()

        #plt.show()
        plt.savefig(self.data_type+'.png', dpi = 100)

        #send file
        send = SendFile(fileName = self.data_type + '.png')
        send.send()