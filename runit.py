# coding=gbk
from flask import Flask
import pandas as pd
from mod_timeseries.weather_model import ProcessData

#Define the WSGI application object

app = Flask(__name__)

#通过路由访问函数
@app.route('/helloworld')
def hello_world():
    return 'Hello World！'

@app.route('/')
def index():
    return 'Index Page.'

#动态URL
@app.route('/user/<username>')
def show_user_profile(username):
    # show the user profile for that user
    return 'User %s' % username

@app.route('/post/<int:post_id>')
def show_post(post_id):
    # show the post with the given id, the id is an integer
    return 'Post %d' % post_id

@app.route('/picture')
def show_pic():
    data = pd.read_csv('F:/Git/Weather/maxmin.csv', parse_dates=['date'])
    p = ProcessData(data, 10, 'max')
    p.process_minmax()


if __name__ == '__main__':
    app.debug = True
    app.run(host = '127.0.0.1', debug = True, port = 9000) 