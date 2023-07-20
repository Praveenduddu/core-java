package de.zeroco.exception;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileSearch {
	
	public static void main(String[] args) {
		System.out.println(findFilePaths("hello.java"));
	}
	
	public static String findFilePaths(String fileName) {
        String filePaths = "";
        File[] roots = File.listRoots();
        List<File> directories = new ArrayList<>();
        for (File root : roots) {
            directories.add(root);
        }
        while (!directories.isEmpty()) {
            File directory = directories.remove(directories.size() - 1);
            File[] fileList = directory.listFiles();
            if (fileList != null) {
                for (File file : fileList) {
                    if (file.isDirectory()) {
                        directories.add(file);
                    } else if (file.getName().equalsIgnoreCase(fileName)) {
                        if (!filePaths.isEmpty()) {
                            filePaths = filePaths + ";\n";
                        }
                        filePaths = filePaths + file.getAbsolutePath();
                    }
                }
            }
        }
        return filePaths;
    }
}

