package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.WriterService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String toFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFile))) {
            bufferedWriter.write("fruit,quantity");
            bufferedWriter.write(Storage.fruitTransactions.stream().flatMap(s -> Arrays.stream(s)).collect(Collectors.joining(",")));
        } catch (IOException ex) {
            throw new RuntimeException("Can't write to file " + toFile);
        }
    }
}
