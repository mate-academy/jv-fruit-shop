package service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> readFromFile(String fileName) {
        List<String> lineWithFile = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(fileName))) {
            String line = reader.readLine();
            while (line != null) {
                lineWithFile.add(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't file with this name" + fileName, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file" + fileName, e);
        }
        return lineWithFile;
    }
}
