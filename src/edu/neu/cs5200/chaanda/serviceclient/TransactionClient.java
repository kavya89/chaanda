package edu.neu.cs5200.chaanda.serviceclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;



public class TransactionClient {
	
	public String insertTransaction(String donorAccountNumber , String passKey , String recieverAccountNumber , String amount){
	
		try {
			
			//URL url = new URL("http://localhost:8080/transAPI/rest/trans/2/donor1/1/16");
			URL url = new URL("http://localhost:8080/transAPI/rest/trans/" + donorAccountNumber + "/" + passKey + "/" + recieverAccountNumber + "/" + amount);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			
			InputStreamReader isr = new InputStreamReader(conn.getInputStream());
			BufferedReader br= new BufferedReader(isr);
			
			String output ;
			StringBuffer buffer = new StringBuffer();
			
			while((output = br.readLine()) != null){
				
				buffer.append(output);
			}
			
			return buffer.toString();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Transaction failed";
}
	
	public String getAccountNumbers(String holderName){
		String output = "";
		try {
			URL url = new URL("http://localhost:8080/transAPI/rest/trans/" + holderName);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			
			InputStreamReader isr = new InputStreamReader(conn.getInputStream());
			BufferedReader br= new BufferedReader(isr);
			
			
			List<Integer> accNums = new ArrayList<Integer>();
			
			output = br.readLine();
			System.out.println(output);
			
			//List<Integer> accs = new ObjectMapper().readValue(output, ArrayList);
					
			/*while((output = br.readLine()) != null){
				
				System.out.println(output);
				System.out.println("kavya");
				//accNums.add(Integer.parseInt(output));
			}*/
			
			return output;
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return output;
}
	
	public static void main(String[] args){
		
		TransactionClient c = new TransactionClient();
		
		c.getAccountNumbers("donor1");
		/*List<Integer> accs = c.getAccountNumbers("donor1");
		
		for(Integer i : accs){
			System.out.println(i);
		}*/
	}
}
