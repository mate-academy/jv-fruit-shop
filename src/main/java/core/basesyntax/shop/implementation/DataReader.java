package core.basesyntax.shop.implementation;

import core.basesyntax.shop.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader implements FileReader {
    @Override
    public List<String> readFromInputData(String filePath) {
        List<String> listOfValues = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath))) {
            while (reader.ready()) {
                listOfValues.add(reader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + filePath, e);
        }
        return listOfValues;
    }
}
