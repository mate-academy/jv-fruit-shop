package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public String readData(String fromFile) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fromFile))){
            StringBuilder data = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null && !line.isEmpty()) {
                data.append(line).append(System.lineSeparator());
                line = bufferedReader.readLine();
            }
            return data.toString().trim();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + fromFile, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from this file: " + fromFile, e);
        }
    }
}
