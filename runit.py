# coding=gbk
from flask import Flask

#Define the WSGI application object

app = Flask(__name__)

#ͨ��·�ɷ��ʺ���
@app.route('/helloworld')
def hello_world():
    return 'Hello World��'

@app.route('/')
def index():
    return 'Index Page.'

#��̬URL
@app.route('/user/<username>')
def show_user_profile(username):
    # show the user profile for that user
    return 'User %s' % username

@app.route('/post/<int:post_id>')
def show_post(post_id):
    # show the post with the given id, the id is an integer
    return 'Post %d' % post_id


if __name__ == '__main__':
    app.debug = True
    app.run(host = '127.0.0.1', debug = True, port = 9000) 