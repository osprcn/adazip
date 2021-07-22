package org.zip.adazip.reader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InputReader {

    // get the user input file name ie. app_input.txt
    public List<String> readFile(String filePath) {
        File file = new File(filePath);
        List<String> inputFiles = new ArrayList<>();

        if (file.exists()) {
            FileReader fr = null;   //reads the file
            try {
                fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream

                String line;
                while ((line = br.readLine()) != null) {
                    inputFiles.add("input: " + line);
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
