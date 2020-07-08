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
	 	String i = receive(2,7,22);
	    System.out.println(i);
	}

	//����7��������ַ���,city�ǳ��б�ţ�0��������1���人��2�����ݣ�3��������4������
	public static String receive(int city,int month,int day)  {
		// ���÷��͵�ַ�Ͷ˿ں�
		String ip = "localhost";
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
			
			try {
			    // ��������
			    out.write(month);
			    Thread.sleep(10);
			    out.write(day);
			    Thread.sleep(10);
			    out.write(city);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
			// ����Ӧ��
			String result = inRead.readLine();  
			
			String[] data = result.split(",");
			
			result = "";
			
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
		 		data[n] = data[n].substring(0, 4);
		 	}
			
		 	//�õ�double���͵���������(���϶�)��t�����д������������������ݣ�һ���tmax��tmin����
 	        double[] t = new double[14];
 	        for(int n = 0;n < 14;n++) {
 	        	t[n] = Double.parseDouble(data[n]);
 	        	//���϶ȱ�Ϊ���϶�
 	        	t[n] = (t[n]-32)*5/9;
 	        }
		 	
 	       //�ٱ�ΪString
 	       for(int n = 0;n < 14;n++) {
 	    	   data[n] = (t[n] + "").substring(0, 4);
 	       }
 	        
 	       //String�������
		   for(int n =0; n<14; n++) {
				if(n<=12) {
		 	       result += data[n] + ",";
				}
				else{
				   result += data[n]; 
				}
			}
		    
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