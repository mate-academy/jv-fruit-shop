package service.impl;

import service.Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderImpl implements Reader {
    @Override
    public List<String> readFromFile(String filepath) {
        List<String> readResult = new ArrayList<>();

        try {
            File file = new File(filepath);
            FileReader fr = new FileReader(file);

            try (BufferedReader br = new BufferedReader(fr)) {
                String line = "";
                while ((line = br.readLine()) != null) {
                    readResult.add(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return readResult;
    }
}
