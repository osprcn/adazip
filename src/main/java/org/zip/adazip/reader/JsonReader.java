package org.zip.adazip.reader;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.zip.adazip.AppRequest;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonReader extends InputFileReader {

    public  AppRequest inputJsonFile(String path){
        AppRequest request=null;
        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert JSON string to request object(Apprequest)
            request = mapper.readValue(Paths.get(path).toFile(), AppRequest.class);

            List<String> InputFiles = request.getInputFiles();
            List<String> validFiles = new ArrayList<>();
            for(String file : InputFiles) {
                if(isValidFilePath(file)){
                    validFiles.add(file);
                } else {
                    System.out.println("Input file is not valid" + file);
                }
            }

            request.setInputFiles(validFiles);
            // print book
            System.out.println(request);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return request;
    }
}
