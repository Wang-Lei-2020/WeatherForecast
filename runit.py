# coding=gbk
from flask import Flask
import pandas as pd
from mod_timeseries.weather_model import ProcessData
import socket


app = Flask(__name__)

#通过路由访问函数
@app.route('/helloworld')
def hello_world():
    return 'Hello World！'

@app.route('/')
def index():
    address = ('localhost', 9999)
    server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server.bind(address)
    server.listen(5)
    while True:
       # month, day = server.accept()
        data = client.recv(13)  # 代表从发过来的数据中读取13byte的数据
        data1 = client.recv(4)  # 再接收4byte数据
        x = int.from_bytes(data, byteorder='big', signed=True)
        print(x)
       # client = int.from_bytes(client, byteorder='big', signed=True)
        addr = int.from_bytes(addr, byteorder='big', signed=True)
        print(client)
        print(addr)
        client.sendall(b'3')  # 发送消息给客户端，发送的消息必须是byte类型
        client.close()  # 关闭连接
    server.close()

#动态URL
@app.route('/user/<username>')
def show_user_profile(username):
    # show the user profile for that user
    return 'User %s' % username

@app.route('/post/<int:post_id>')
def show_post(post_id):
    # show the post with the given id, the id is an integer
    return 'Post %d' % post_id


@app.route('/data/<int:month>/<int:day>')
def tempForcast(month,day):
    predict = []
    data = pd.read_csv('F:/Git/Weather/maxmin.csv', parse_dates=['date'])
    n = 0

    for i in range(day+1,day+8):
        data.query("date.dt.day == @month & date.dt.month == @i", inplace=True)

        p = ProcessData(data, 10, 'max')
        dta = p.process_minmax()
        print(dta)
        #predict[n] = dta
        n = n + 1

    print(predict)
    return str(month) + " - " +  str(day)


if __name__ == '__main__':
    app.debug = True
    app.run(host = '127.0.0.1', debug = True, port = 9000) 