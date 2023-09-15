package service.impl;

import database.Storage;
import java.io.BufferedWriter;
import java.io.IOException;
import model.FruitTransaction;
import service.FileWriter;

public class FileWriterImpl implements FileWriter {
    private static final String FILE_PATH = "src/main/resources/report.csv";
    private static final String TITLE = "fruit,quantity";

    @Override
    public void writeReport() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new java.io.FileWriter(FILE_PATH))) {
            bufferedWriter.write(TITLE + System.lineSeparator());
            for (FruitTransaction fruitTransaction : Storage.FRUIT_DTOS) {
                bufferedWriter.write(String.format("%s,%s%s", fruitTransaction.getName(),
                        fruitTransaction.getQuantity(), System.lineSeparator()));
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + FILE_PATH, e);
        }
    }
}
