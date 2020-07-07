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
		String ip = "127.0.0.1";        // ���÷��͵�ַ�Ͷ˿ں�
		int port = 9999;
		Socket socket = null;
		try {
			// ���ӷ�����
			socket = new Socket(ip, port);
			// ��ȡ������
			InputStream in = socket.getInputStream();   //��ȡ����
			// ��ȡ�����
			OutputStream out = socket.getOutputStream(); // ��������
			// ��װ�����������������װһ�¿���ֱ�Ӵ����ַ���������װ�Ļ�ֱ��ʹ��InputStream��OutputStreamֻ��ֱ�Ӵ���byte[]��������
			BufferedReader inRead = new BufferedReader(new InputStreamReader(in));
//			PrintWriter outWriter = new PrintWriter(out);
			
			// ��������
			out.write(month);
			out.write(day);
		
			// ����Ӧ��
			String result = inRead.readLine();  // ʹ���˰�װ��������������ȡ��Ϣ
			return result;
		} catch(UnknownHostException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return "defeat";
	}
	
}

