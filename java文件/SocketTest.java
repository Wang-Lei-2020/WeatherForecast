import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTest {

	public static void main(String[] args) {
		//获取Json数据
	 	String i = receive(7,16);
	 	System.out.print(i);
	 	//分割字符串
	 	String[] data = i.split(",");
	 	System.out.println();
	 	//得到String类型的数据
	 	for(int n = 0;n < 14;n++) {
	 		if(n == 0) {
	 			data[n] = cut(data[n],15);
	 		}
	 		else if(n == 13) {
	 			data[n] = cut(data[n],14);
	 			data[n] = data[n].substring(0, data[n].length()-2);
	 		}
	 		else {
	 	        data[n] = cut(data[n],14);
	 		}
	 	  System.out.println(data[n]);
	 	}
	 	
	 	//得到double类型的气温数据(摄氏度)
	 	double[] t = new double[14];
	 	for(int n = 0;n < 14;n++) {
	 		t[n] = Double.parseDouble(data[n]);
	 		//华氏度变为摄氏度
	 		t[n] = (t[n]-32)*5/9;
	 		System.out.println(t[n]);
	 	}
	 	
	}

	public static String receive(int month,int day) {
		// 设置发送地址和端口号
		String ip = "127.0.0.1";
		int port = 9999;
		Socket socket = null;
		try {
			// 连接服务器
			socket = new Socket(ip, port);
			// 获取输入流
			InputStream in = socket.getInputStream();   //读取数据
			// 获取输出流
			OutputStream out = socket.getOutputStream(); // 发送数据
			BufferedReader inRead = new BufferedReader(new InputStreamReader(in));
			
			// 发送数据
			out.write(month);
			out.write(day);
		
			// 接受应答
			String result = inRead.readLine();  
		    
			return result;
			
		} catch(UnknownHostException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return "default";
	}
	
	//去掉字符串的前几位
	public static String cut(String origin, int count) {    
		if (origin == null || origin.length() < count) {        
			return null;    
			}    
		char[] arr = origin.toCharArray();    
		char[] ret = new char[arr.length - count];    
		for (int i = 0; i < ret.length; i++) {        
			ret[i] = arr[i + count];    
			}    
		
		return String.copyValueOf(ret);
		}
	
}
