import socket
import pandas as pd
import statsmodels.api as sm
from mod_timeseries.process_json import format_json
import json

address = ('127.0.0.1', 9999)  #ip地址和端口
# 创建socket对象，同时设置通信模式，AF_INET代表IPv4，SOCK_STREAM代表流式socket，使用的是tcp协议
server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
# 绑定到我们刚刚设置的ip和端口元组，代表我们的服务运行在本机的9999端口上
server.bind(address)
# 开始监听，5位最大挂起的连接数
server.listen(5)
# 无限循环，实现反复接收请求
while True:
	# accept()方法被动接受客户端连接，阻塞，等待连接. client是客户端的socket对象，可以实现消息的接收和发送，addr表示客户端的地址
	client, addr = server.accept()
	month = client.recv(13)  # 代表从发过来的数据中读取13byte的数据
	day = client.recv(4)   # 再接收4byte数据
	month = int().from_bytes(month, byteorder='big', signed=True) #接受的数据类型为byte 转换为int
	day = int().from_bytes(day, byteorder='big', signed=True)
	print(month)
	print(day)

	#从文件中查询该日期以后七天的气温数据
	data = pd.read_csv('F:/Git/Weather/beijing.csv', parse_dates=['date'])
	data.query("date.dt.day == @day & date.dt.month == @month", inplace=True)
	tmax1 = data['tmax'].values[0]
	tmin1 = data['tmin'].values[0]

	day = day + 1
	data = pd.read_csv('F:/Git/Weather/beijing.csv', parse_dates=['date'])
	data.query("date.dt.day == @day & date.dt.month == @month", inplace=True)
	tmax2 = data['tmax'].values[0]
	tmin2 = data['tmin'].values[0]

	day = day + 1
	data = pd.read_csv('F:/Git/Weather/beijing.csv', parse_dates=['date'])
	data.query("date.dt.day == @day & date.dt.month == @month", inplace=True)
	tmax3 = data['tmax'].values[0]
	tmin3 = data['tmin'].values[0]

	day = day + 1
	data = pd.read_csv('F:/Git/Weather/beijing.csv', parse_dates=['date'])
	data.query("date.dt.day == @day & date.dt.month == @month", inplace=True)
	tmax4 = data['tmax'].values[0]
	tmin4 = data['tmin'].values[0]

	day = day + 1
	data = pd.read_csv('F:/Git/Weather/beijing.csv', parse_dates=['date'])
	data.query("date.dt.day == @day & date.dt.month == @month", inplace=True)
	tmax5 = data['tmax'].values[0]
	tmin5 = data['tmin'].values[0]

	day = day + 1
	data = pd.read_csv('F:/Git/Weather/beijing.csv', parse_dates=['date'])
	data.query("date.dt.day == @day & date.dt.month == @month", inplace=True)
	tmax6 = data['tmax'].values[0]
	tmin6 = data['tmin'].values[0]

	day = day + 1
	data = pd.read_csv('F:/Git/Weather/beijing.csv', parse_dates=['date'])
	data.query("date.dt.day == @day & date.dt.month == @month", inplace=True)
	tmax7 = data['tmax'].values[0]
	tmin7 = data['tmin'].values[0]

	temp = [tmax1,tmin1,tmax2,tmin2,tmax3,tmin3,tmax4,tmin4,tmax5,tmin5,tmax6,tmin6,tmax7,tmin7]
	temp = pd.Series(temp)
	temp.index = pd.Index(sm.tsa.datetools.dates_from_range(str(1), str(14)))

	print(temp)
	temp.to_json('weather.json',date_format = 'iso')
	temp_json = format_json('weather.json', str(month), str(day-6))

	print(temp_json)

	client.send(bytes(repr(json.dumps(temp_json)).encode('utf-8')))

	#client.sendall(b'3')    # 发送消息给客户端，发送的消息必须是byte类型
	client.close()        # 关闭连接
server.close()
