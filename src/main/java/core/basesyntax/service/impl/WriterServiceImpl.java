package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Collectors;

public class WriterServiceImpl implements WriterService {
    private static final String HEADER = "fruit, quantity";

    @Override
    public void writeToFile(String toFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFile))) {
            bufferedWriter.write(HEADER);
            bufferedWriter.newLine();
            String content = Storage.fruitTransactions
                    .stream()
                    .map(fruit -> fruit.getFruit() + "," + fruit.getQuantity())
                    .collect(Collectors.joining(System.lineSeparator()));
            bufferedWriter.write(content);
        } catch (IOException ex) {
            throw new RuntimeException("Can't write to file " + toFile);
        }
    }
}
