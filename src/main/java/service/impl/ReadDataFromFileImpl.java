package service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import service.ReadDataFromFile;

public class ReadDataFromFileImpl implements ReadDataFromFile {
    private final List<String> listString = new ArrayList<>();

    @Override
    public List<String> getData(String fromFileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fromFileName))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                listString.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + fromFileName, e);
        }
        return listString;
    }
}
