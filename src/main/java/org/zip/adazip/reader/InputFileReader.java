package org.zip.adazip.reader;

import java.io.File;
import java.io.IOException;

public abstract class InputFileReader {

    //check the path(inside the inputfiles) is valid or not then add this valid in inputFiles
    protected boolean isValidFilePath(String path) {
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
}
