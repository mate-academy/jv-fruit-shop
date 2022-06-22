package servise.impl;


import servise.FileReaderService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find the file: " + filePath, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file: " + filePath, e);
        }
    }
}
