import socketTest,os,threading

class SendFile():
    def __init__(self, serverAdd="127.0.0.1", serverPort = 9000, fileName=""):
        self.address = (serverAdd,serverPort)
        self.fileName = fileName

    def send(self):
        s = socketTest.socketTest(socketTest.AF_INET, socketTest.SOCK_STREAM)
        print(11111111)
        s.connect(self.address)
        print(22222222)
        send_file = os.path.normcase(self.fileName)
        try:
            f = open(send_file, "rb")
            print(f)
            send_file_thread = SendFileThread(s,f)
            send_file_thread.start()
        except IOError:
            print("  error!")

class SendFileThread(threading.Thread):
    def __init__(self,sock, file):
        threading.Thread.__init__(self)
        self.sock = sock
        self.file = file

    def run(self):
        print("file name is ==" + self.file.name)
        BUFFERSIZE = 1024
        count = 0
        while True:
            file_data = self.file.read(BUFFERSIZE)
            if not file_data:
                print("no data find")
                break
            self.sock.send(file_data)
        print("send file ok")
        self.file.close()
        self.sock.close()
