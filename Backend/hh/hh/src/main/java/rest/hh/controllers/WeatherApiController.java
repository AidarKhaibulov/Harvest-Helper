package rest.hh.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.hh.auth.SecurityUtil;
import rest.hh.models.User;
import rest.hh.services.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherApiController {
    private final UserService userService;

    @GetMapping("/{city}")
    public ResponseEntity<String> getTips(@PathVariable String city) throws IOException {
        String text = callApi(city, "weather");
        return ResponseEntity.ok(text);
    }

    @GetMapping("/alert/{city}")
    public ResponseEntity<String> checkAlert(@PathVariable String city) throws IOException {
        User u = userService.findByEmail(SecurityUtil.getSessionUser()).get();
        if (u.getNotifications()) {
            String text = callApi(city, "forecast");
            Pattern pattern = Pattern.compile("<temperature unit=\"celsius\" value=\"-?\\d+.\\d+\" min=\"(-?\\d+.\\d+)\"");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                System.out.println(Double.parseDouble(matcher.group(1)));
                if (Double.parseDouble(matcher.group(1)) < 0.00) {
                    System.out.println("ALERT!");
                    break;
                } 
            }
            return ResponseEntity.ok(text);
        }
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("notifications/{toggle}")
    public ResponseEntity notification(@PathVariable boolean toggle) {
        User u = userService.findByEmail(SecurityUtil.getSessionUser()).get();
        u.setNotifications(toggle);
        return userService.save(u);
    }

    private String callApi(String city, String method) throws IOException {
        String id = "b1c34ff82615fee84de5da8523f7a397";
        URL url = new URL("https://api.openweathermap.org/data/2.5/" + method + "?q=" + city + "&appid=" + id + "&mode=xml&units=metric&lang=RU");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        return content.toString();
    }

}
