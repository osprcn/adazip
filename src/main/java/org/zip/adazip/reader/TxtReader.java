package org.zip.adazip.reader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TxtReader extends InputFileReader {

    // get the user input file name ie. app_input.txt
    //this method return as List<String> bcz inside the filepath all exits path is consider as string
    public List<String> readFile(String filePath) {
        File file = new File(filePath);
        List<String> inputFiles = new ArrayList<>();

        if (file.exists()) {
            FileReader fr = null;   //reads the file
            try {
                fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream
                //each read path take as string (inside the path line by line )
                String path;
                while ((path = br.readLine()) != null) {
                    //check that string(inside the inputfiles) is correct path path or not
                    boolean isPathExist = isValidFilePath(path) ;
                    if(isPathExist){
                        //inside txt file is exit then add in result output(inputFiles)
                        inputFiles.add(path);
                    }
                    else{
                        System.out.println("Input file is not correct " + path);
                    }

                }
                fr.close();    //closes the stream and release the resources

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return inputFiles;
    }


}
