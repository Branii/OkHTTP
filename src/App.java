import java.io.IOException;
import org.json.simple.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class App {

    static OkHttpClient client = new OkHttpClient();
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    
    public static void main(String[] args) throws IOException {
   
        String url = "http://69.49.228.42/1kball/selenium/serve.php"; 

        JSONObject obj =new JSONObject(); 
        obj.put("TableName","draw_10026"); 
        obj.put("DrawDate","date");   
        obj.put("DrawTime","time");   
        obj.put("DrawNumber","12345");   
        obj.put("DrawCount","0011");
        obj.put("DateCreated","10-10-10");  
        obj.put("DrawGet","11-11-11");  
                     
     

        //System.out.println(obj.toJSONString());

        String datas = post(url,obj.toJSONString());
        System.out.println(datas);
    }


    static String run(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    static String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
            .url(url)
            .post(body)
            .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

}
