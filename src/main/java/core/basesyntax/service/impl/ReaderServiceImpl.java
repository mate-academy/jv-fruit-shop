package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {

    @Override
    public List<String> readFromFile() {
        File file = new File("src/main/resources/inputdata.csv");
        List<String> listLines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                listLines.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file by path: " + file, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + e);
        }
        return listLines;
    }
}
