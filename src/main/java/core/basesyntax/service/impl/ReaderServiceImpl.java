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
    public List<String> readData(String fromFile) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fromFile))){
            List<String> listData = new ArrayList<>();
            StringBuilder data = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null && !line.isEmpty()) {
                data.append(line).append(" "); //TODO: Magick number
                listData.add(data.toString());
                line = bufferedReader.readLine();
            }
            return listData;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + fromFile, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from this file: " + fromFile, e);
        }
    }
}
