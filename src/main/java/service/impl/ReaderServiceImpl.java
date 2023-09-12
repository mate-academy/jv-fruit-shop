package service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    private final List<String> readLines;

    public ReaderServiceImpl() {
        this.readLines = new ArrayList<>();
    }

    @Override
    public void readDataFromFile(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String stringLine = reader.readLine();
            stringLine = reader.readLine();
            while (stringLine != null) {
                readLines.add(stringLine);
                stringLine = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + file.getPath(), e);
        }
    }

    @Override
    public List<String> getReadLines() {
        return readLines;
    }
}
