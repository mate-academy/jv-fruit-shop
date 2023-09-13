package service.impl;

import exception.InvalidDataException;
import model.Fruit;
import service.WriteToFile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteToFileImpl implements WriteToFile {
    private static final String FILE_PATH = "src/main/resources/report.csv";
    private static final String TITLE = "fruit,quantity";

    @Override
    public void writeReport(List<Fruit> fruits) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH))) {
            bufferedWriter.write(TITLE + System.lineSeparator());
            for (Fruit fruit : fruits) {
                bufferedWriter.write(String.format("%s,%s%s",
                        fruit.getName(), fruit.getQuantity(), System.lineSeparator()));
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + FILE_PATH, e);
        }
    }
}
