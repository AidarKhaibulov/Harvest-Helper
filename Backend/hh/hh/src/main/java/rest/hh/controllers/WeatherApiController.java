package rest.hh.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherApiController {
    @GetMapping("/{city}")
    public ResponseEntity<String> getTips(@PathVariable String  city) throws IOException {
        String id = "b1c34ff82615fee84de5da8523f7a397";
        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+ id +"&mode=xml&units=metric");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        System.out.println(content);
        return ResponseEntity.ok(content.toString());
    }
}
