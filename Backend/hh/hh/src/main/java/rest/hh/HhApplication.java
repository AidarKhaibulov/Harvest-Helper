package rest.hh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@SpringBootApplication
public class HhApplication {
	public static  String SECRET_KEY="";
	public static void main(String[] args) throws IOException {
		try (
				InputStream is2 = HhApplication.class.getResourceAsStream("/sk.txt");
				BufferedReader reader2 = new BufferedReader(new InputStreamReader(is2))
		)
		{
			SECRET_KEY= reader2.readLine();
		}
		SpringApplication.run(HhApplication.class, args);
	}

}
