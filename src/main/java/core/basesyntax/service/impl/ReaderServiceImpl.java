package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.ReaderService;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderServiceImpl implements ReaderService {
    private FileReader reader = new FileReaderImpl();

    @Override
    public List<FruitTransaction> getTransactions(String filePath) {
        List<String> records = reader.readLines(filePath);
        return records.stream()
                .skip(1)
                .map(s -> new FruitTransaction(
                        FruitTransaction.Operation.of(s.split(",")[0]),
                        new Fruit(s.split(",")[1]),
                        Integer.parseInt(s.split(",")[2])))
                .collect(Collectors.toList());
    }
}

