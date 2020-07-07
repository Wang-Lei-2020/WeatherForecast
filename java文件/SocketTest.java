import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTest {

	public static void main(String[] args) {
	 	String i = receive(7,15);
	 	System.out.print(i);
	}

	public static String receive(int month,int day) {
		String ip = "127.0.0.1";        // 设置发送地址和端口号
		int port = 9999;
		Socket socket = null;
		try {
			// 连接服务器
			socket = new Socket(ip, port);
			// 获取输入流
			InputStream in = socket.getInputStream();   //读取数据
			// 获取输出流
			OutputStream out = socket.getOutputStream(); // 发送数据
			// 包装输入流，输出流，包装一下可以直接传输字符串，不包装的话直接使用InputStream和OutputStream只能直接传输byte[]类型数据
			BufferedReader inRead = new BufferedReader(new InputStreamReader(in));
//			PrintWriter outWriter = new PrintWriter(out);
			
			// 发送数据
			out.write(month);
			out.write(day);
		
			// 接受应答
			String result = inRead.readLine();  // 使用了包装后的输入流方便读取消息
			return result;
		} catch(UnknownHostException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return "defeat";
	}
	
}

