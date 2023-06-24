package service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public String readFromFile(String fileToRead) {
        if (fileToRead == null) {
            throw new RuntimeException("Unknown path to file:" + fileToRead);
        }
        File file = new File(fileToRead);
        StringBuilder result = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String value = br.readLine();
            while (value != null) {
                result.append(value).append(System.lineSeparator());
                value = br.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found:" + fileToRead, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file:" + fileToRead, e);
        }
        return result.toString().trim();
    }
}
