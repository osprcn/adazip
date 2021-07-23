package org.zip.adazip;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.zip.adazip.reader.JsonReader;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {

//		SpringApplication.run(Application.class, args);

		JsonReader inputFileReader = new JsonReader();
		/*	1.create obj(inputreader) of   the InputReader(class)
			2.and call readfiles(method) and pass the argument as **filepath
			3.makes **filepath as input.txt file that store path(likes as Array of string)of multiple files and folders
			4.contain output(input) as List<String>(conatins multiple file and folder)
			5.print path which is in the form of  strings(exits inside the inputs)
		*/
		AppRequest inputs = inputFileReader.inputJsonFile("inpurt/input.json");
		System.out.println("Format of the partion = "+ inputs.getPartition().getFormat());
		System.out.println("Size of the partion = "+ inputs.getPartition().getSize());
		for (String str: inputs.getFiles()) {
			System.out.println(str);
		}

	}

}
