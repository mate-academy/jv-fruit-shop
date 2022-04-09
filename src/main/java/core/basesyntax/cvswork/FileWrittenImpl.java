package core.basesyntax.cvswork;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrittenImpl implements FileWrite {
    @Override
    public void writeFile(String csvAddress) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvAddress))) {
            writer.write("fruit,quantity");
            writer.write(System.getProperty("line.separator"));
            for (Fruit line : Storage.FRUIT_LIST) {
                writer.write(line.getName() + "," + line.getQuantity());
                writer.write(System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            throw new RuntimeException(" Can`t create file" + csvAddress, e);
        }
    }
}
