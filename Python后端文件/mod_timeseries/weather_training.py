# coding=gbk

import pandas as pd
import numpy as np
from Tools.scripts.make_ctype import values
from scipy import stats
import matplotlib.pyplot as plt
import statsmodels.api as sm
from statsmodels.graphics.api import qqplot #qqͼ

data = pd.read_csv('F:/Git/Weather/maxmin.csv', parse_dates = ['date'])
data.query("date.dt.day == 4 & date.dt.month == 7",inplace = True)
dta = data['tmin']
dta_year = data['date']

#�õ���ʼ��ݺͽ������
begin_year = dta_year[0:1].dt.year    # index value
end_year = dta_year[-1:].dt.year

#������������
dta = np.array(dta,dtype = np.float)
#ת��ΪSeries���͵�һά����
dta = pd.Series(dta)
dta.index = pd.Index(sm.tsa.datetools.dates_from_range(str(begin_year.values[0]), str(end_year.values[0])))
dta.plot(figsize=(10,6))
plt.show();

fig = plt.figure(figsize = (12,8))
ax1 = fig.add_subplot(111)
diff1 = dta.diff(1)
diff1.plot(ax=ax1)
plt.show()

diff1 = dta.diff(1)
fig = plt.figure(figsize = (12,8))
ax1 = fig.add_subplot(211)
fig = sm.graphics.tsa.plot_acf(dta,lags = 30,ax = ax1)
ax2 = fig.add_subplot(212)
fig = sm.graphics.tsa.plot_pacf(dta,lags = 30,ax = ax2)
plt.show()

arma_mod76 = sm.tsa.ARMA(dta,(7,6)).fit()
print(arma_mod76.aic,arma_mod76.bic,arma_mod76.hqic)

#ʹ��ARMA(7,6)ģ��


resid = arma_mod76.resid
fig = plt.figure(figsize = (12,8))
ax1 = fig.add_subplot(211)  #2�У���1�У���1����ʼλ��
fig = sm.graphics.tsa.plot_acf(resid.values.squeeze(),lags = 30,ax = ax1)
ax2 = fig.add_subplot(212)  #2�У���1�У���2����ʼλ��
fig = sm.graphics.tsa.plot_pacf(resid,lags = 30,ax = ax2)

#��֤ģ��
fig = plt.figure(figsize = (12,8))
ax = fig.add_subplot(111)
fig = qqplot(resid,line = 'q',ax = ax,fit = True)
plt.show()

#����Ԥ������
#δ��10��ͬһ���Ԥ������
predict_year = 10
predict_end_year = end_year.values[0] + predict_year
predict_dta = arma_mod76.predict(str(end_year.values[0] + 1),str(predict_end_year),dynamic = True)
print(predict_dta)