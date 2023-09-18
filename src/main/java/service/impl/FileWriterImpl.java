package service.impl;

import database.Storage;
import java.io.BufferedWriter;
import java.io.IOException;
import model.FruitTransaction;
import service.FileWriter;

public class FileWriterImpl implements FileWriter {
    private static final String TITLE = "fruit,quantity";

    @Override
    public void writeReport(String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new java.io.FileWriter(filePath))) {
            bufferedWriter.write(TITLE + System.lineSeparator());
            for (FruitTransaction fruitTransaction : Storage.FRUIT_DTOS) {
                bufferedWriter.write(String.format("%s,%s%s", fruitTransaction.getName(),
                        fruitTransaction.getQuantity(), System.lineSeparator()));
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + filePath, e);
        }
    }
}
