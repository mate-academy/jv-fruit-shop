package service.impl;

import service.*;

import java.io.*;
import java.util.*;

public class FileReaderServiceImpl implements FileReaderService {
    String filePath;

    public FileReaderServiceImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<String> readFromFile() throws IOException {
        List<String> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            throw new IOException("Error reading the file: " + filePath, e);
        }
        return list;
    }
}
