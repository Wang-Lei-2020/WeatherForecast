# -*- coding: utf-8 -*-
"""
Created on Sun Jul  5 18:28:08 2020

@author: user
"""

# 导入数据
import pandas as pd
import matplotlib.pyplot as plt
from statsmodels.graphics.tsaplots import plot_acf, plot_pacf
from statsmodels.tsa.stattools import adfuller
from statsmodels.stats.diagnostic import acorr_ljungbox
from statsmodels.tsa.arima_model import ARIMA 

filename = r'E:\maxmin.csv'
maxfilename = r'E:\max.csv'
minfilename = r'E:\min.csv'

data = pd.read_csv(filename, index_col=u'date')
maxdata = pd.read_csv(maxfilename, index_col=u'date')
mindata = pd.read_csv(minfilename, index_col=u'date')

# 画出时序图
plt.rcParams['font.sans-serif'] = ['SimHei']  # 定义使其正常显示中文字体黑体
plt.rcParams['axes.unicode_minus'] = False  # 用来正常显示表示负号
#data.plot()
#plt.show()

#画出自相关性图
#plot_acf(maxdata)
#plt.show()

#plot_pacf(maxdata)
#plt.show()

#plot_acf(mindata)
#plt.show()

#plot_pacf(mindata)
#plt.show()
#平稳性检测

#print('原始序列的检验结果为：',adfuller(mindata[u'tmin']))
#print('原始序列的检验结果为：',adfuller(maxdata[u'tmax']))


#对数据进行差分后得到 自相关图和 偏相关图
maxD_data = maxdata.diff().dropna()
maxD_data.columns = [u'tmax']
 
maxD_data.plot()   #画出差分后的时序图
plt.show()
 
plot_acf(maxD_data)    #画出自相关图
plt.show()
plot_pacf(maxD_data)   #画出偏相关图
plt.show()
print(u'差分序列的ADF 检验结果为： ', adfuller(maxD_data[u'tmax']))   #平稳性检验

minD_data = mindata.diff().dropna()
minD_data.columns = [u'tmin']
 
minD_data.plot()   #画出差分后的时序图
plt.show()
 
plot_acf(minD_data)    #画出自相关图
plt.show()
plot_pacf(minD_data)   #画出偏相关图
plt.show()
print(u'差分序列的ADF 检验结果为： ', adfuller(minD_data[u'tmin']))   #平稳性检验

#对一阶差分后的序列做白噪声检验
print(u'差分序列的白噪声检验结果：',acorr_ljungbox(maxD_data, lags= 1)) #返回统计量和 p 值
# 差分序列的白噪声检验结果： (array([11.30402222]), array([0.00077339])) p值为第二项， 远小于 0.05
print(u'差分序列的白噪声检验结果：',acorr_ljungbox(minD_data, lags= 1))
 
#对模型进行定阶
pmax = int(len(minD_data) / 10)    #一般阶数不超过 length /10
qmax = int(len(minD_data) / 10)
bic_matrix = []
for p in range(pmax +1):
    temp= []
    for q in range(qmax+1):
        try:
            temp.append(ARIMA(mindata, (p, 1, q)).fit().bic)
        except:
            temp.append(None)
        bic_matrix.append(temp)

bic_matrix = pd.DataFrame(bic_matrix)   #将其转换成Dataframe 数据结构
p,q = bic_matrix.stack().astype('float64').idxmin()   #先使用stack 展平， 然后使用 idxmin 找出最小值的位置
print(u'BIC 最小的p值 和 q 值：%s,%s' %(p,q))  #  BIC 最小的p值 和 q 值：0,1
#所以可以建立ARIMA 模型，ARIMA(0,1,1)
model = ARIMA(mindata, (p,1,q)).fit()
model.summary2()        #生成一份模型报告
model.forecast(5)   #为未来5天进行预测， 返回预测结果， 标准误差， 和置信区间