package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterServiceImpl implements WriterService {

    private static final String OUTPUT_FILE_PATH = "src/main/resources/fileBalance.csv";

    @Override
    public void writeBalanceOfFruitToFile(String balance) {
        try (Writer writer = new FileWriter(OUTPUT_FILE_PATH)) {
            writer.append(balance);
        } catch (IOException e) {
            throw new RuntimeException("Can't write balance to file ", e);
        }
    }
}

