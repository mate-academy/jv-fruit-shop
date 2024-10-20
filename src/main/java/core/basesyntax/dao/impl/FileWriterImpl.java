package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitFileWriter;
import core.basesyntax.model.FruitTransaction;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileWriterImpl implements FruitFileWriter {
    @Override
    public void write(List<FruitTransaction> report, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (FruitTransaction transaction : report) {
                String line = transaction.getOperation() + "," + transaction.getFruit() + "," + transaction.getQuantity();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while writing to a file: " + filename, e);
        }
    }
}