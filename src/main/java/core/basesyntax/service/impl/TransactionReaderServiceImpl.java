package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TransactionReaderServiceImpl implements TransactionReaderService {
    private static final String FILE_NAME = "src/main/resources/input.csv";

    @Override
    public List<FruitTransaction> read() {
        List<String> linesFromFile;
        try {
            linesFromFile = Files.readAllLines(Path.of(FILE_NAME));
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file: " + FILE_NAME);
        }
        List<FruitTransaction> transactionsFromFile = new ArrayList<>();
        String[] transactionDetails;
        for (int i = 1; i < linesFromFile.size(); i++) {
            transactionDetails = linesFromFile.get(i).split(",");
            transactionsFromFile.add(
                    new FruitTransaction(FruitTransaction.Operation.fromCode(transactionDetails[0]),
                                                            transactionDetails[1],
                                                            Integer.parseInt(transactionDetails[2]))
            );
        }
        return transactionsFromFile;
    }
}
