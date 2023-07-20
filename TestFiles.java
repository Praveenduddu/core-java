package de.zeroco.exception;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestFiles {
    public static void main(String[] args) {
    	System.out.println(getListOfFilePath("sample.json"));
    }
    
    public static List<File> getListOfFilePath(String fileName) {
    	File[] roots = File.listRoots();
        List<File> foundFiles = new ArrayList<>();
        for (File root : roots) {
            List<File> rootFoundFiles = searchFiles(root.getAbsolutePath(), fileName);
            foundFiles.addAll(rootFoundFiles);
        }
        return foundFiles;
    }

    public static List<File> searchFiles(String directoryPath, String fileName) {
        List<File> foundFiles = new ArrayList<>();
        File directory = new File(directoryPath);
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.getName().equalsIgnoreCase(fileName)) {
                        foundFiles.add(file);
                    }
                    if (file.isDirectory()) {
                        foundFiles.addAll(searchFiles(file.getAbsolutePath(), fileName));
                    }
                }
            }
        }
        return foundFiles;
    }
}

