package core.basesyntax.service.impl;

import core.basesyntax.model.FruitInStorage;
import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public class CsvWriterServiceImpl implements WriterService {
    private static final String FIRST_LINE = "fruit,quantity";
    private static final String FIELD_SEPARATOR = ",";
    private File file;

    public CsvWriterServiceImpl(String filePath) {
        this.file = new File(filePath);
    }

    @Override
    public void write(Collection<FruitInStorage> fruits) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(FIRST_LINE);
            for (FruitInStorage fruit : fruits) {
                writer.write(System.lineSeparator() + fruit.getName()
                        + FIELD_SEPARATOR + fruit.getAmount());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + file);
        }
    }
}
