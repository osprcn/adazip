package org.zip.adazip;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.zip.adazip.reader.InputReader;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);

		InputReader inputReader = new InputReader();
		List<String> inputs = inputReader.readFile("/home/chhavi/dev/adazip/inpurt/app_input.txt");

		for (String str: inputs) {
			System.out.println(str);
		}

		//
	}

}
