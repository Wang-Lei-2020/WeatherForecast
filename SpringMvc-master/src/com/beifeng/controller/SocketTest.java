package com.beifeng.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTest {

	public static String test(int city,int month,int day) {
		//锟斤拷取Json锟斤拷锟斤拷
	 	String i = receive(city,month,day);
	    System.out.println(i);
	    return i;
	}

	//锟斤拷锟斤拷7锟斤拷锟斤拷锟斤拷锟斤拷址锟斤拷锟�,city锟角筹拷锟叫憋拷牛锟�0锟斤拷锟斤拷锟斤拷锟斤拷1锟斤拷锟戒汉锟斤拷2锟斤拷锟斤拷锟捷ｏ拷3锟斤拷锟斤拷锟斤拷锟斤拷4锟斤拷锟斤拷锟斤拷
	public static String receive(int city,int month,int day)  {
		// 锟斤拷锟矫凤拷锟酵碉拷址锟酵端口猴拷
		String ip = "localhost";
		int port = 9999;
		Socket socket = null;
		try {
			// 锟斤拷锟接凤拷锟斤拷锟斤拷
			socket = new Socket(ip, port);
			// 锟斤拷取锟斤拷锟斤拷锟斤拷
			InputStream in = socket.getInputStream();   //锟斤拷取锟斤拷锟斤拷
			// 锟斤拷取锟斤拷锟斤拷锟�
			OutputStream out = socket.getOutputStream(); // 锟斤拷锟斤拷锟斤拷锟斤拷
			BufferedReader inRead = new BufferedReader(new InputStreamReader(in));
			
			try {
			    // 锟斤拷锟斤拷锟斤拷锟斤拷
			    out.write(month);
			    Thread.sleep(10);
			    out.write(day);
			    Thread.sleep(10);
			    out.write(city);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
			// 锟斤拷锟斤拷应锟斤拷
			String result = inRead.readLine();  
			
			String[] data = result.split(",");
			
			result = "";
			
		 	//锟矫碉拷String锟斤拷锟酵碉拷锟斤拷锟斤拷
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
			
		 	//锟矫碉拷double锟斤拷锟酵碉拷锟斤拷锟斤拷锟斤拷锟斤拷(锟斤拷锟较讹拷)锟斤拷t锟斤拷锟斤拷锟叫达拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟捷ｏ拷一锟斤拷锟絫max锟斤拷tmin锟斤拷锟斤拷
 	        double[] t = new double[14];
 	        for(int n = 0;n < 14;n++) {
 	        	t[n] = Double.parseDouble(data[n]);
 	        	//锟斤拷锟较度憋拷为锟斤拷锟较讹拷
 	        	t[n] = (t[n]-32)*5/9;
 	        }
		 	
 	       //锟劫憋拷为String
 	       for(int n = 0;n < 14;n++) {
 	    	   data[n] = (t[n] + "").substring(0, 4);
 	       }
 	        
 	       //String锟斤拷锟斤拷锟斤拷锟�
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
	
	//去锟斤拷锟街凤拷锟斤拷锟斤拷前锟斤拷位
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