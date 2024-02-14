package service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    private static final int EMPTY_SIZE = 0;

    @Override
    public List<String> readFromFile(String filePath) {
        BufferedReader bufferedReader;
        List<String> stringsReader = new ArrayList<>();
        File file = new File(filePath);
        if (file.exists()) {
            try (FileInputStream fileInStream = new FileInputStream(file)) {
                if (fileInStream.available() != EMPTY_SIZE) {
                    bufferedReader = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringsReader.add(line);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException("Can't read the file " + filePath, e);
            }
        }
        return stringsReader;
    }
}
