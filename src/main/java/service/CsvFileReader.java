package service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReader implements ReadCsvFile {

    @Override
    public List<String> readCsvFile(String fileName) {
        List<String> fileContent = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(fileName))) {
            reader.readLine(); //removing headers from file
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file with such name " + fileName, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + fileName, e);
        }
        return fileContent;
    }
}
