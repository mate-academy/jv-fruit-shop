package core.basesyntax.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> readFile(String fileName) {
        List<String> lineArray = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lineArray.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found" + fileName, e);
        } catch (IOException e) {
            throw new RuntimeException("Cant read file" + fileName, e);
        }

        return lineArray;
    }
}
