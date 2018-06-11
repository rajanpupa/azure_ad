package com.example.clientapp;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@SpringBootApplication
public class ClientAppApplication {

	public static void main(String[] args) throws IOException {
		//SpringApplication.run(ClientAppApplication.class, args);
		spiderman("SpiderMan");
	}

	public static void spiderman(String str) throws IOException {

		String urlStr = "https://jsonmock.hackerrank.com/api/movies/search/?Title="+str + "&page=";

		JsonNode jsonNode = getJsonNode(urlStr + "1");

		int totalPages = jsonNode.get("total_pages").intValue();
		System.out.println(totalPages);

	}

	private static JsonNode getJsonNode(String urlStr) throws IOException {
		URL url = new URL(urlStr);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");

		InputStream is = con.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line ;
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		br.close();
		ObjectMapper objectMapper= new ObjectMapper();

		String val = sb.toString();
		JsonNode jsonNode = objectMapper.readTree(val);
		return jsonNode;
	}
}
