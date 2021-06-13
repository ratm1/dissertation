package org.standrews.schedulingsurgeries.view;

import io.vertx.core.json.JsonArray;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
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
             String responseJSON = EntityUtils.toString(response.getEntity(),"UTF-8");
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

    public String getSurgeries() throws IOException {
        String responseJSON = "";
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        try {
            HttpGet request = new HttpGet("http://localhost:8080/surgeries");
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

    public Integer[] getAnesthesiaTypes() throws IOException {
        Integer[] responseJSON = new Integer[0];
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        try {
            HttpGet request = new HttpGet("http://localhost:8080/anesthesiatypes");
            request.addHeader("content-type", "application/json");
            CloseableHttpResponse response = httpClient.execute(request);
            responseJSON = parseJsonAnesthesiaTypes(EntityUtils.toString(response.getEntity(),  "UTF-8"));
            return responseJSON;
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpClient.close();
        }
        return responseJSON;
    }

    public Integer[] getSurgeryTypes() throws IOException {
        Integer[] responseJSON = new Integer[0];
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        try {
            HttpGet request = new HttpGet("http://localhost:8080/surgerytypes");
            request.addHeader("content-type", "application/json");
            CloseableHttpResponse response = httpClient.execute(request);
            responseJSON = parseJsonSurgeryTypes(EntityUtils.toString(response.getEntity(),  "UTF-8"));
            return responseJSON;
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpClient.close();
        }
        return responseJSON;
    }

    public String[] getProcedures() throws IOException {
        String[] responseJSON = new String[0];
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        try {
            HttpGet request = new HttpGet("http://localhost:8080/procedures");
            request.addHeader("content-type", "application/json");
            CloseableHttpResponse response = httpClient.execute(request);
            responseJSON = parseJsonProcedures(EntityUtils.toString(response.getEntity(),  "UTF-8"));
            return responseJSON;
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpClient.close();
        }
        return responseJSON;
    }

    public Integer getAnesthesiaTypeId(Integer code) throws IOException {
        Integer responseJSON = -1;
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        try {
            HttpGet request = new HttpGet("http://localhost:8080/anesthesiatypes/" + code);
            request.addHeader("content-type", "application/json");
            CloseableHttpResponse response = httpClient.execute(request);
            responseJSON = Integer.parseInt(EntityUtils.toString(response.getEntity(),  "UTF-8"));
            return responseJSON;
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpClient.close();
        }
        return responseJSON;
    }

    public String[] parseJsonProcedures(String response) {
        JSONArray procedures = new JSONArray(response);
        String[] procedureNames = new String[procedures.length()];
        for (int counter = 0; counter < procedures.length(); counter++) {
            JSONObject procedure = procedures.getJSONObject(counter);
            procedureNames[counter] = procedure.getString("name");
        }
        return procedureNames;
    }

    public Integer[] parseJsonSurgeryTypes(String response) {
        JSONArray surgeryTypes = new JSONArray(response);
        Integer[] surgeryTypesIds = new Integer[surgeryTypes.length()];
        for (int counter = 0; counter < surgeryTypes.length(); counter++) {
            JSONObject surgeryType = surgeryTypes.getJSONObject(counter);
            surgeryTypesIds[counter] = surgeryType.getInt("surgeryTypeId");
        }
        return surgeryTypesIds;
    }

    public Integer[] parseJsonAnesthesiaTypes(String response) {
           JSONArray anesthesiaTypes = new JSONArray(response);
           Integer[] arrayAnesthesiaCodes = new Integer[anesthesiaTypes.length()];
           for (int counter = 0; counter < anesthesiaTypes.length(); counter++) {
               JSONObject anesthesiaType = anesthesiaTypes.getJSONObject(counter);
               arrayAnesthesiaCodes[counter] = anesthesiaType.getInt("code");
           }
           return arrayAnesthesiaCodes;
    }

    /*
    public HashMap<Integer, ArrayList> getSurgeriesTwo() throws IOException {
        HashMap<Integer, ArrayList> scheduledSurgeriesMap = new HashMap<>();
        String responseJSON = "";
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        try {
            HttpGet request = new HttpGet("http://localhost:8080/surgeries");
            request.addHeader("content-type", "application/json");
            CloseableHttpResponse response = httpClient.execute(request);
            responseJSON = EntityUtils.toString(response.getEntity(),  "UTF-8");
            return scheduledSurgeriesMap;
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpClient.close();
        }
        return scheduledSurgeriesMap;
    }
     */
}
