package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.Reader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderImpl implements Reader {
    private static final String SEPARATOR = ",";
    private static final int TITLE_INDEX = 0;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> read(String path) {
        List<String> fruitTransactions;
        try {
            fruitTransactions = Files.readAllLines(Path.of(path));
            fruitTransactions.remove(TITLE_INDEX);
        } catch (IOException e) {
            throw new RuntimeException("Error reading fruit transactions from " + path);
        }
        return fruitTransactions.stream()
                .map(this::getFruitTransactionFromFile)
                .toList();
    }

    private FruitTransaction getFruitTransactionFromFile(String infoFromFile) {
        String[] fruitFields = infoFromFile.split(SEPARATOR);
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(
                Operation.getOperationFromCode(fruitFields[OPERATION_INDEX].trim()));
        fruitTransaction.setFruit(fruitFields[FRUIT_INDEX].trim());
        fruitTransaction.setQuantity(Integer.parseInt(fruitFields[QUANTITY_INDEX].trim()));
        return fruitTransaction;
    }
}
