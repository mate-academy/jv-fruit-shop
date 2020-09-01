package core.basesyntax.service;

import core.basesyntax.model.FruitBox;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadOperationFromFileService {
    private static final String SPLITTER = ",";
    private static final Strategy STRATEGY = new Strategy();

    public void read(String filePath) {
        FruitBoxDtoParser fruitParser = new FruitBoxDtoParser();
        FruitBox fruit;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(SPLITTER);
                fruit = fruitParser.parse(line);
                STRATEGY.getOperator(data[0]).execute(fruit);
            }
        } catch (IOException e) {
            throw new RuntimeException("Wrong path");
        }
    }
}
