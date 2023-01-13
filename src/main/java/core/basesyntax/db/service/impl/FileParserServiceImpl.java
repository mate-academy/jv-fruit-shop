package core.basesyntax.db.service.impl;

import core.basesyntax.db.model.FruitTransaction;
import core.basesyntax.db.service.FileParserService;
import java.util.List;
import java.util.stream.Collectors;

public class FileParserServiceImpl implements FileParserService {
    private static final String REGEX = ",";
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_QUANTITY = 2;

    @Override
    public List<FruitTransaction> parse(List<String> inputFile) {
        return inputFile.stream()
                .map(this::toTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction toTransaction(String line) {
        String[] splitLine = line.split(REGEX);
        FruitTransaction transaction = new FruitTransaction();
        transaction.setOperation(FruitTransaction.Operation
                .getOperationStrChar(splitLine[INDEX_OPERATION]));
        transaction.setFruit(splitLine[INDEX_FRUIT]);
        transaction.setQuantity(Integer.parseInt(splitLine[INDEX_QUANTITY]));
        return transaction;
    }
}
