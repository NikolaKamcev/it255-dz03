/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IT255.Post;

/**
 *
 * @author Nikola
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        User u = new User();
        u.setId(0);
        u.setPostId(0);
        u.setEmail("caoca@met.com");
        u.setName("Baka5616");
        u.setBody("Ovo je body");
  
       
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/comments");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestProperty("Method", "POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            PrintWriter pw = new PrintWriter(conn.getOutputStream());
            pw.print(new Gson().toJson(u));
         
            pw.close();
            pw.flush();
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            String output;
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
