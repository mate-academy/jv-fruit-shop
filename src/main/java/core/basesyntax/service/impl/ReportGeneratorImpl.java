package core.basesyntax.service.impl;

import core.basesyntax.db.FruitInventory;
import core.basesyntax.service.ReportGenerator;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_HEADER = "fruit,quantity" + System.lineSeparator();

    @Override
    public void generate(String path) {
        File file = new File(path);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Couldn't create the file");
        }

        try {
            Files.write(file.toPath(), REPORT_HEADER.getBytes(), StandardOpenOption.APPEND);
            for (var entry: FruitInventory.getInventory().entrySet()) {
                String lineToWrite = entry.getKey()
                        + "," + entry.getValue()
                        + System.lineSeparator();
                Files.write(file.toPath(), lineToWrite.getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
