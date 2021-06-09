package org.standrews.schedulingsurgeries.view;

import io.vertx.core.json.JsonArray;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import java.io.IOException;

public class RequestHandler {

     public void solve() throws IOException {
         CloseableHttpClient httpClient = HttpClientBuilder.create().build();
         try {
             HttpPost request = new HttpPost("http://localhost:8080/timeTable/solve");
             request.addHeader("content-type", "application/json");
             CloseableHttpResponse response = httpClient.execute(request);
         } catch (Exception e) {
             e.printStackTrace();
         } finally {
             httpClient.close();
         }
     }

     public int getNumberOperatingRooms() throws IOException {
         int numberOfRooms = 0;
         CloseableHttpClient httpClient = HttpClientBuilder.create().build();
         try {
             HttpGet request = new HttpGet("http://localhost:8080/rooms");
             request.addHeader("content-type", "application/json");
             CloseableHttpResponse response = httpClient.execute(request);
             String responseJSON = EntityUtils.toString(response.getEntity());
             JSONArray rooms = new JSONArray(responseJSON);
             numberOfRooms = rooms.length();
             return numberOfRooms;

         } catch (Exception e) {
             e.printStackTrace();
         } finally {
             httpClient.close();
         }
         return numberOfRooms;
     }


    public String getSolution() throws IOException {
        String responseJSON = "";
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        try {
            HttpGet request = new HttpGet("http://localhost:8080/timeTable/solution");
            request.addHeader("content-type", "application/json");
            CloseableHttpResponse response = httpClient.execute(request);
            responseJSON = EntityUtils.toString(response.getEntity(),  "UTF-8");
            return responseJSON;
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpClient.close();
        }
        return responseJSON;
    }
}
