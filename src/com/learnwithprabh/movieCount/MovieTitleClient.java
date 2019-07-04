package com.learnwithprabh.movieCount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class MovieTitleClient {
	static int totalPages = 0;

	public static void main(String[] args) throws Exception{
        String[] res;
        
        res = getMovieTitles("spiderman");
        System.out.println("............Searching movie title per single page.............");
        for(String str:res) {
        	System.out.println(str);
        }
        
        res = getMovieTitlesPerPage("spiderman");
        System.out.println("...............Searching movie title per single page...........");
        for(String str:res) {
        	System.out.println(str);
        }
        
        System.out.println("Total No of title:"+getTotalNoOfTitle("spiderman"));
        
	}
	
	    static String[] getMovieTitles(String substr) throws IOException{
	        String[] array=null;
	        StringBuilder sb= new StringBuilder();
	        sb.append("https://jsonmock.hackerrank.com/api/movies/search/?Title=");
	        sb.append(substr);
	        String s = sb.toString();
	        URL url = new URL(s);
	        HttpURLConnection connect = (HttpURLConnection) url.openConnection();
	        connect.setRequestMethod("GET");
	        int resCode = connect.getResponseCode();
			
	        if(resCode == 200){	
	           BufferedReader br = new BufferedReader(new InputStreamReader(connect.getInputStream()));
	            String line;
				
	            while((line=br.readLine())!=null){	
	                JsonObject json = new Gson().fromJson(line, JsonObject.class);
	                JsonArray jarray = json.getAsJsonArray("data");
	                array = new String[jarray.size()];
					for(int j=0;j<jarray.size();j++) {
						json = jarray.get(j).getAsJsonObject();
						String result = json.get("Title").toString().replaceAll("\"", "");;
						array[j] = result;
					}
					Arrays.sort(array);
					return array;
	            } 
	        }
	        return array;
	    }
	    
	    static String[] getMovieTitlesPerPage(String substr) {
	    	String response;
	    	int startPage = 1;
	    	int totalPages = Integer.MAX_VALUE;
	    	List<String> titles = new ArrayList<>();
	    	while (startPage <= totalPages) {
	    	  try {
	    	    URL obj = new URL("https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr + "&page=" + startPage);
	    	    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	    	    con.setRequestMethod("GET");
	    	    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	    	    while ((response = in.readLine()) != null) {
	    	      JsonObject convertedObject = new Gson().fromJson(response, JsonObject.class);
	    	      totalPages = convertedObject.get("total_pages").getAsInt();
	    	      JsonArray data = convertedObject.getAsJsonArray("data");
	    	      for (int i = 0; i < data.size(); i++) {
	    	        String title = data.get(i).getAsJsonObject().get("Title").getAsString();
	    	        titles.add(title);
	    	      }
	    	    }
	    	    in.close();
	    	    startPage++;
	    	  } catch (Exception ex) {
	    	    ex.printStackTrace();
	    	  }
	    	}
	    	Collections.sort(titles);
	    	return titles.toArray(new String[0]);
	    	}
	    
	    static int getTotalNoOfTitle(String str) throws Exception {
	    	int total=0;
	    	URL obj = new URL("https://jsonmock.hackerrank.com/api/movies/search/?Title="+str);
	    	HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    	    con.setRequestMethod("GET");
    	    BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
    	    String readLine = br.readLine();
    	    while(readLine!=null) {
    	    	JsonObject jsonObj = new Gson().fromJson(readLine, JsonObject.class);
    	    	total = jsonObj.get("total").getAsInt();
    	    	readLine = br.readLine();
    	    }
	    	return total;
	    }

}
