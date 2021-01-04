package service.Implementation;

import db.FruitStorage;
import model.Fruit;
import service.DataWriter;

import java.io.*;
import java.util.Map;

public class CsvDataWriterImpl implements DataWriter {
    public static final String FILE_PATH = "src/main/resources/";

    @Override
    public void writeToFile(String fileTo) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH + fileTo))) {
                bufferedWriter.write(getDataFromFruitStorage());
            } catch (IOException e) {
                throw new RuntimeException("Can not write data to file: " + fileTo, e);
            }
    }

    private String getDataFromFruitStorage() {
        StringBuilder builder = new StringBuilder("fruit,quantity" + System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry : FruitStorage.fruitStorage.entrySet()) {
            builder.append(entry.getKey().getName())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}

