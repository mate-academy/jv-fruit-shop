package servise.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import servise.FileReaderService;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> readFile(String filePath) {
        List<String> fileLines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))) {
            String line = br.readLine();
            while (line != null) {
                fileLines.add(line);
                line = br.readLine();
            }
            return fileLines;
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file: " + filePath, e);
        }
    }
}
