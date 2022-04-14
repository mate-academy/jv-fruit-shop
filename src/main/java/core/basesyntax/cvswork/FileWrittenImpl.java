package core.basesyntax.cvswork;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class FileWrittenImpl implements FileWriter {
    @Override
    public void write(String filePath) {
        if (new File(filePath).exists()) {
            try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(filePath))) {
                writer.write("fruit,quantity");
                writer.write(System.getProperty("line.separator"));
                for (Fruit line : Storage.fruits) {
                    writer.write(line.getName() + "," + line.getQuantity());
                    writer.write(System.getProperty("line.separator"));
                }
            } catch (IOException e) {
                throw new RuntimeException("No readable file" + e);
            }
        } else {
            throw new RuntimeException("No create file");
        }
    }
}
