package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

@RestController
public class GTPController {

    private static final String template = "This is test gtp named %s";

    @GetMapping("/test")
    public StringBuffer test(@RequestParam(value = "name", defaultValue = "Song") String name) {
        StringBuffer content = new StringBuffer();
        try
        {
            URL url = new URL("https://nordicmaster.github.io/table_items.json");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content;
        /*return new GTPItem("1",
                           String.format(template, name),
                           1,2,45,130,
                           "q","d", true, false, false);*/
    }
}