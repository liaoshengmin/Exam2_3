package com.hand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class Exam2_3_1 {

	public static void main(String[] args) {
		new Get().start();


	}
}

class Get extends Thread{
	HttpClient client = HttpClients.createDefault();

	@Override
	public void run() {
		HttpGet get = new HttpGet("http://hq.sinajs.cn/list=sh601006");
		try {

			HttpResponse response =client.execute(get);
			HttpEntity entity = response.getEntity();
			String result = EntityUtils.toString(entity);

			String input[] = result.split(",");
			for (int i = 0; i < input.length; i++) {
				System.out.println(i+":"+input[i]);
				
			}
			


		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

