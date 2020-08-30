package core.basesyntax.service;

import core.basesyntax.exceptions.WrongFormatException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReaderFromFile implements FileService {
    @Override
    public List<List<String>> readFile(String filePath) {
        List<List<String>> orders = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while (!((line = br.readLine()) == null)) {
                List<String> singleLine = Arrays.asList(line.split(","));
                if (singleLine.size() == 4) {
                    orders.add(singleLine);
                } else {
                    throw new WrongFormatException("Incorrect format");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("This file does not exist!", e);
        }
        if (orders != null && orders.size() != 0) {
            orders.remove(0);
        }
        return orders;
    }
}
