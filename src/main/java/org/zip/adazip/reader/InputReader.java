package org.zip.adazip.reader;

import java.io.*;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class InputReader {
    //check the path is valid or not then add this valid in inputlist
    public static boolean isValidFilePath(String path) {
        File f = new File(path);
        try {
            f.getCanonicalPath();
            return f.exists();
        } catch (IOException e) {
            return false;
        } finally {
            f = null;
        }
    }

    // get the user input file name ie. app_input.txt
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
