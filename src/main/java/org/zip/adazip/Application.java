package org.zip.adazip;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.zip.adazip.reader.JsonReader;

import java.io.File;
import java.io.IOException;

import static org.zip.adazip.Zip.compress;


@SpringBootApplication
//Developed
public class Application {

	public static void main(String[] args) {

//		SpringApplication.run(Application.class, args);
		//gtot the method(cltr+click)
		JsonReader inputFileReader = new JsonReader();

		AppRequest inputs = inputFileReader.inputJsonFile("inpurt/input.json");

		System.out.println("Format of the partion = "+ inputs.getPartition().getFormat());
		System.out.println("Size of the partion = "+ inputs.getPartition().getSize());

		//make our zip file with the same name of input file /home/nidhi/dev/adazip/output/bin
		//cut the part bin.zip
		String res = inputs.getOutputDir();
		System.out.println("Json output path = " + res);

		for (String str: inputs.getInputFiles()) {
			System.out.println("input path = " + str);

			//code for get compress(zip) path with the same name of input path
			//so fetch the input path name
			File f = new File(str);
			String outpath = f.getName();
			System.out.println("output path name = " + outpath);
			try {
				compress(str,res+outpath+".zip");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}


	}

}
