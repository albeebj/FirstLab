package com.parnas.kwic.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {
	
	private Socket socket;
	private BufferedReader br;
	private PrintWriter os;
	private BufferedReader is;
	
	public SocketClient(){
		try{
			
			socket = new Socket("127.0.0.1", 8000);
			br = new BufferedReader(new InputStreamReader(System.in));
			os = new PrintWriter(socket.getOutputStream());
			is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		}catch(Exception e) {
			System.out.println("Error"+e); //�������ӡ������Ϣ
		}

	}
	
	public void dataSettler(){
		
		String readline;
		
		try {
			System.out.println("Please input line: (Input 'bye' to finish inputting)");
			System.out.println(">");
			readline = br.readLine();
			
			while(!readline.equals("bye")){
				os.println(readline);
				os.flush();

				System.out.println(">");
				readline=br.readLine(); //��ϵͳ��׼�������һ�ַ���
			} 
			os.println(readline);
			os.close(); //�ر�Socket�����
			is.close(); //�ر�Socket������
			socket.close(); //�ر�Socket
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //��ϵͳ��׼�������һ�ַ���
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			SocketClient sc = new SocketClient();
			sc.dataSettler();
		}
}
