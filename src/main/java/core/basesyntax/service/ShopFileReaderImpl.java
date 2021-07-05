package core.basesyntax.service;

import core.basesyntax.dto.OperationType;
import core.basesyntax.dto.Transaction;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShopFileReaderImpl implements ShopFileReader {
    @Override
    public List<Transaction> readFromFile(String fileName) {
        List<Transaction> dataFromFile = new ArrayList<>();
        File file = new File(fileName);
        if (file.exists()) {
            try {
                dataFromFile = Files.readAllLines(Path.of(fileName))
                        .stream()
                        .skip(1)
                        .filter(p -> new ValidatorImpl().isLineValid(p))
                        .map(p -> p.split(","))
                        .map(p -> new Transaction(OperationType
                                .getOperationType(p[0]), p[1], Integer.parseInt(p[2])))
                                .collect(Collectors.toList());

            } catch (IOException e) {
                throw new RuntimeException("Can`t read from file: " + fileName);
            }
        }

        return dataFromFile;
    }
}
