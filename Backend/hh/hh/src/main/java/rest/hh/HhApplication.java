package rest.hh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@SpringBootApplication
public class HhApplication {
	public static  String SECRET_KEY="404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970";
	public static void main(String[] args)  {

		SpringApplication.run(HhApplication.class, args);

	}

}
