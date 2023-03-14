package service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import service.FileReaderService;

public class FileReaderServiceImpl implements FileReaderService {

    @Override
    public List<String> readFromFile(String inputFilePath) {
        File inputFile = new File(inputFilePath);
        List<String> lines = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
            String line = bufferedReader.readLine();
            while (line != null) {
                lines.add(line);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("This file was not found " + e
                    + "Check the path or the name of File");
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file " + e + "Please, use valid file");
        }
        return lines;
    }
}
