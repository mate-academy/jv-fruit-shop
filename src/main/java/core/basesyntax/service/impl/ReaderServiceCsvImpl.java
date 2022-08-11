package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReaderService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderServiceCsvImpl implements ReaderService {
    private static final int TITLE_LINE_INDEX = 0;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> read(String filePath) {
        File file = new File(filePath);
        try {
            List<String> linesFromFile = Files.readAllLines(file.toPath());
            linesFromFile.remove(TITLE_LINE_INDEX);
            return linesFromFile.stream()
                    .map(this::getTransaction)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't find file " + filePath);
        }
    }

    private FruitTransaction getTransaction(String lineFromFile) {
        String[] transaction = lineFromFile.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(fruitTransaction
                .getOperationByLetter(transaction[OPERATION_INDEX]));
        fruitTransaction.setFruit(transaction[FRUIT_NAME_INDEX]);
        fruitTransaction.setQuantity(Integer.parseInt(transaction[FRUIT_QUANTITY_INDEX]));
        return fruitTransaction;
    }
}
