# -*- coding: utf-8 -*-
"""
Created on Sun Jul  5 18:23:03 2020

@author: user
"""

#load the data
import pandas as pd
data = pd.read_csv('E:\\min.csv')
#print(data)

#divide into train and validation set
train = data[:int(0.7*(len(data)))]
valid = data[:int(0.7*(len(data)))]

#preprocessing
train.drop('date',axis=1,inplace=True)
valid.drop('date',axis=1,inplace=True)

#plotting the data
train['tmin'].plot()
valid['tmin'].plot()

#building the model
from pmdarima import auto_arima
model = auto_arima(train,trace=True,error_action='ignore',suppress_warnings=True)
model.fit(train)

forecast = model.predict(n_periods=len(valid))
forecast = pd.DataFrame(forecast,index = valid.index,columns = ['Prediction'])

#plot the predictions for validation set
import matplotlib.pyplot as plt
plt.plot(train,label='Train',color='BLUE')
plt.plot(valid,label='Valid')
plt.plot( forecast,label='Predication',color='RED')
plt.show()

#calculate rmse
from math import sqrt
from sklearn.metrics import mean_squared_error

rms = sqrt(mean_squared_error(valid,forecast))
print(rms)