import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTest {

	public static void main(String[] args) {
		//city是城市编号，0：北京，1：武汉，2：广州，3：沈阳，4：昆明，5：长春
                        //6：常德  7：敦煌 8:福州  9：桂平  10：哈尔滨
                       //11：杭州 12：合肥 13：呼和浩特 14：济南 15：:遵义
                       //16：拉萨 17：南昌 18：南充 19：南京 20：齐齐哈尔
                       //21：郑州 22：石家庄 23：太原 24：乌鲁木齐 25：西宁
                       //26：延安 27：延川 28：天津
	 	String i = receive(28,7,21);
	    System.out.println(i);
	}

	//city是城市编号,0：北京，1：武汉，2：广州，3：沈阳，4：昆明，5：长春
                   //6：常德  7：敦煌 8:福州  9：桂平  10：哈尔滨
                  //11：杭州 12：合肥 13：呼和浩特 14：济南 15：:遵义
                  //16：拉萨 17：南昌 18：南充 19：南京 20：齐齐哈尔
                  //21：郑州 22：石家庄 23：太原 24：乌鲁木齐 25：西宁
                  //26：延安 27：延川  28：天津
	//month和day分别是month和day参数
	public static String receive(int city,int month,int day)  {
		//连接主机和端口
		String ip = "localhost";
		int port = 9999;
		Socket socket = null;
		try {
			//连接socket
			socket = new Socket(ip, port);
			// 获取输入流
			InputStream in = socket.getInputStream(); 
			// 获取输出流
			OutputStream out = socket.getOutputStream();
			BufferedReader inRead = new BufferedReader(new InputStreamReader(in));
			
			try {
			    //向服务器发送参数
			    out.write(month);
			    Thread.sleep(10);
			    out.write(day);
			    Thread.sleep(10);
			    out.write(city);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
			// 返回Json类型的数据
			String result = inRead.readLine();  
			
			String[] data = result.split(",");
			
			result = "";
			
		 	//对返回数据进行处理
			if(data[0].charAt(10) < '3' ) {
		 	   for(int n = 0;n < 14;n++) {
		 		   System.out.println(data[n]);
		 		   if(n == 0) {
		 		   	   data[n] = cut(data[n],15);
		 		   }
		 		   else if(n == 13) {
		 			   data[n] = cut(data[n],14);
		 			   data[n] = data[n].substring(0, data[n].length()-2);
		 		   }
		 		   else {
		 	            data[n] = cut(data[n],13);
		 		   }
		 		   
		 		   data[n] = data[n].substring(0, 4);
		 		
		 	   }
			}
			else {
				for(int n = 0;n < 14;n++) {
			 		   if(n == 0) {
			 		   	   data[n] = cut(data[n],14);
			 		   }
			 		   else if(n == 13) {
			 			   data[n] = cut(data[n],13);
			 			   data[n] = data[n].substring(0, data[n].length()-2);
			 		   }
			 		   else {
			 	            data[n] = cut(data[n],12);
			 		   }
			 		   data[n] = data[n].substring(0, 4);
			 		
			 		   //System.out.println(data[n]);
			 	   }
			}
			
		 	//先变为double数组，将华氏度变为摄氏度
 	        double[] t = new double[14];
 	        for(int n = 0;n < 14;n++) {
 	        	t[n] = Double.parseDouble(data[n]);
 	        	t[n] = (t[n]-32)*5/9;
 	        }
		 	
 	       //再将double变为String类型，便于前端同学使用
 	       for(int n = 0;n < 14;n++) {
 	    	   data[n] = (t[n] + "").substring(0, 4);
 	       }
 	        
 	       //String字符串将数据连接
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
	
	//去掉字符串中前count个字符
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