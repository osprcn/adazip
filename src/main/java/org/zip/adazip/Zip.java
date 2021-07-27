package org.zip.adazip;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    private static final FileFilter FOLDER_FILTER = new FileFilter() {
        @Override
        public boolean accept(File pathname) {
            return pathname.isDirectory();
        }
    };

    private static final FileFilter FILE_FILTER = new FileFilter() {
        @Override
        public boolean accept(File pathname) {
            return pathname.isFile();
        }
    };

    private static void compress(File file, ZipOutputStream outputStream, String path) throws IOException {
        if (file.isDirectory()) {
            File[] subFiles = file.listFiles(FILE_FILTER);
            if (subFiles != null) {
                for (File subFile : subFiles) {
                    compress(subFile, outputStream, new File(path, subFile.getName()).getAbsolutePath());
                }
            }
            File[] subDirs = file.listFiles(FOLDER_FILTER);
            if (subDirs != null) {
                for (File subDir : subDirs) {
                    compress(subDir, outputStream, new File(path, subDir.getName()).getAbsolutePath());
                }
            }
        } else if (file.exists()) {
            outputStream.putNextEntry(new ZipEntry(path));
            FileInputStream inputStream = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) >= 0) {
                outputStream.write(buffer, 0, len);
            }
            outputStream.closeEntry();
        }
    }
    //overload that method bcz code reusability
    public static void compress(String dirPath, String zipFilePath) throws IOException {
        File file = new File(dirPath);
        final ZipOutputStream outputStream = new ZipOutputStream(new FileOutputStream(zipFilePath));
        //compress method call in Application class(main)
        compress(file, outputStream, "/");
        outputStream.close();
    }
}
