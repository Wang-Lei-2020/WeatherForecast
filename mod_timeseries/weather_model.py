# coding=gbk
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import statsmodels.api as sm
from pmdarima import auto_arima
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
        print(begin_year)
        end_year = data_year[-1:].dt.year
        predict_month = data_year[0:1].dt.month
        predict_day = data_year[0:1].dt.day
        max_data = np.array(max_data, dtype = np.float)
        print(max_data)

        #转换为一维数组
        max_data = pd.Series(max_data)
        print(max_data)
        max_data.index = pd.Index(sm.tsa.datetools.dates_from_range(str(begin_year.values[0]), str(end_year.values[0])))
        print(max_data)

        train = max_data.loc['1980-12-31':'2012-12-31']
        test = max_data.loc['2013-12-31':]

        arma_mod76 = auto_arima(train,start_p=1,start_q=1,max_p=8,max_q=8,start_P=1,start_Q=1,max_P=1,max_Q=1,m=12,seasonal=True,
                                trace=True,error_action='ignore',stepwise=True,suppress_warnings=True,d=1,D=1)
        arma_mod76.fit(train)
        predict_end_year = end_year.values[0] + self.predict_year
        predict_dta = arma_mod76.predict(n_periods=len(test))
        print(predict_dta)
        print(11111111)
        predict_dta = pd.Series(predict_dta)
        predict_dta.index = pd.Index(sm.tsa.datetools.dates_from_range(str(end_year.values[0]-11), str(predict_end_year-11)))#DataFrame(predict_dta, index=test.index)

        print(predict_dta)

        predict_dta.to_json(self.data_type+'.json',date_format = 'iso')
        json_date = format_json(self.data_type+'.json',str(predict_month.values[0]), str(predict_day.values[0]))
        print(json_date)
        fig, ax = plt.subplots(figsize=(12,8))
        ax = train.loc[str(begin_year.values[0]):].plot(ax=ax)
        predict_dta.plot()

        #fig = plot.gcf()

        #plt.show()
        plt.savefig(self.data_type+'.png', dpi = 100)

        #send file
        send = SendFile(fileName = self.data_type + '.png')
        send.send()