import socket
import pandas as pd
# 在构建socket的时候需要用到ip和端口，必须是元组的形式。
# 另外，因为是本机上的两个程序通信，所以设置成localhost，
# 如果要和网络上的其他主机进行通信，则填上相应主机的ip地
# 址，端口的话随便设置一个，不要和已知的一些服务冲突就行
address = ('127.0.0.1', 9999)
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
	month = int().from_bytes(month, byteorder='big', signed=True)
	day = int().from_bytes(day, byteorder='big', signed=True)
	print(month)
	print(day)
	data = pd.read_csv('F:/Git/Weather/beijing.csv', parse_dates=['date'])
	data.query("date.dt.day == @day & date.dt.month == @month", inplace=True)
	print(data)
	#for i in range()

	client.sendall(b'3')    # 发送消息给客户端，发送的消息必须是byte类型
	client.close()        # 关闭连接
server.close()
