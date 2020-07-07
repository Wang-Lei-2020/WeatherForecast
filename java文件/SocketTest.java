import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTest {

	public static void main(String[] args) {
		//��ȡJson����
	 	String i = receive(7,16);
	 	System.out.print(i);
	 	//�ָ��ַ���
	 	String[] data = i.split(",");
	 	System.out.println();
	 	//�õ�String���͵�����
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
	 	
	 	//�õ�double���͵���������(���϶�)
	 	double[] t = new double[14];
	 	for(int n = 0;n < 14;n++) {
	 		t[n] = Double.parseDouble(data[n]);
	 		//���϶ȱ�Ϊ���϶�
	 		t[n] = (t[n]-32)*5/9;
	 		System.out.println(t[n]);
	 	}
	 	
	}

	public static String receive(int month,int day) {
		// ���÷��͵�ַ�Ͷ˿ں�
		String ip = "127.0.0.1";
		int port = 9999;
		Socket socket = null;
		try {
			// ���ӷ�����
			socket = new Socket(ip, port);
			// ��ȡ������
			InputStream in = socket.getInputStream();   //��ȡ����
			// ��ȡ�����
			OutputStream out = socket.getOutputStream(); // ��������
			BufferedReader inRead = new BufferedReader(new InputStreamReader(in));
			
			// ��������
			out.write(month);
			out.write(day);
		
			// ����Ӧ��
			String result = inRead.readLine();  
		    
			return result;
			
		} catch(UnknownHostException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return "default";
	}
	
	//ȥ���ַ�����ǰ��λ
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
