import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.google.gson.*;


public class CountTitles {
  static int getMovieTitles(String substr) throws IOException{  
      URL url = new URL("https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr);   
      HttpURLConnection connect = (HttpURLConnection) url.openConnection();
      connect.setRequestMethod("GET");
      int total = 0;
      int resCode = connect.getResponseCode();
      if(resCode == 200) {
        BufferedReader br = new BufferedReader(new InputStreamReader(connect.getInputStream()));
        String line=br.readLine();
    		Gson gson = new Gson();
        JsonObject json = gson.fromJson(line, JsonObject.class);
        total = json.get("total").getAsInt();      
      }
   return total;
 } 
   public static void main(String[] args) throws IOException{
     Scanner in = new Scanner(System.in);
      int res;
      String _substr;
      _substr = in.next();
      res = getMovieTitles(_substr);
      System.out.println(res);
  }
}
