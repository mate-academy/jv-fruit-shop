package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationTypeService;
import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderServiceImpl implements ReaderService {
    private static final int HEADER_INDEX = 0;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final OperationTypeService operationTypeService = new OperationTypeServiceImpl();

    @Override
    public List<FruitTransaction> readDataFromFile(String fileName) {
        List<String> fruitTransactions;
        try {
            fruitTransactions = Files.readAllLines(Path.of(fileName));
            fruitTransactions.remove(HEADER_INDEX); // TODO: check it
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file " + fileName);
        }
        return fruitTransactions.stream()
                .map(this::getFromCsvRow)
                .collect(Collectors.toList());
    }

    private FruitTransaction getFromCsvRow(String line) {
        String[] fields = line.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(
                operationTypeService.getOperationType(fields[OPERATION_INDEX]));
        fruitTransaction.setFruitName(fields[FRUIT_NAME_INDEX]);
        fruitTransaction.setQuantity(new BigDecimal(fields[QUANTITY_INDEX]));
        return fruitTransaction;
    }
}
