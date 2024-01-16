package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ReporterService;
import core.basesyntax.service.operation.OperationProvider;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class CsvReporterServiceImpl implements ReporterService, Consumer<String> {
    private static final String COMMA = ",";
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int FIRST_LINE_INDEX = 0;
    private static final BigDecimal START_VALUE = BigDecimal.valueOf(0);
    private Map<String, BigDecimal> map;
    private OperationStrategy operationStrategy;

    public CsvReporterServiceImpl(Map<String, BigDecimal> map,
                                  OperationStrategy operationStrategy) {
        this.map = map;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, BigDecimal> get(List<String> readFile) {
        putUniqueFruits(readFile);
        readFile.forEach(this);
        return map;
    }

    private void throwPossibleException(List<String> readFile) {
        if (readFile.isEmpty()) {
            throw new RuntimeException(
                    "File can't be empty");
        }
        if (!(readFile.get(FIRST_LINE_INDEX).equals("type,fruit,quantity"))
                || readFile.get(FIRST_LINE_INDEX).length() < 3) {
            throw new RuntimeException(
                    "Wrong file format, should be: type,fruit,quantity");
        }
    }

    private void putUniqueFruits(List<String> readFile) {
        throwPossibleException(readFile);
        readFile.remove(FIRST_LINE_INDEX);
        readFile
                .stream()
                .map(string -> string
                            .substring(string.indexOf(COMMA) + 1))
                .map(string -> string.substring(0, string.indexOf(COMMA)))
                .distinct()
                .forEach(string -> map.put(string, START_VALUE));
    }

    private void putNewValue(String string, FruitTransaction.Operation operationToAdd) {
        String[] dividedByComma = string.split(COMMA);
        if (dividedByComma.length < 3
                || !dividedByComma[QUANTITY_INDEX].matches("\\d+")
                || Integer.parseInt(dividedByComma[QUANTITY_INDEX]) < 0) {
            throw new NumberFormatException(
                    "Non-valid input data");
        }
        FruitTransaction fruitTransaction = new FruitTransaction(operationToAdd,
                dividedByComma[FRUIT_INDEX],
                Integer.parseInt(dividedByComma[QUANTITY_INDEX]));
        OperationProvider operationProvider = operationStrategy.get(fruitTransaction.operation());
        map.put(fruitTransaction.fruit(),
                operationProvider.getOperated(fruitTransaction,
                        map.get(fruitTransaction.fruit())));
    }

    @Override
    public void accept(String string) {
        String operation = String.valueOf(string.charAt(0)) + COMMA;
        FruitTransaction.Operation operationToAdd;
        if (operation.equals(FruitTransaction.Operation.BALANCE.getCode() + COMMA)) {
            operationToAdd = FruitTransaction.Operation.BALANCE;
        } else if (operation.equals((FruitTransaction.Operation.SUPPLY.getCode()) + COMMA)) {
            operationToAdd = FruitTransaction.Operation.SUPPLY;
        } else if (operation.equals((FruitTransaction.Operation.RETURN.getCode()) + COMMA)) {
            operationToAdd = FruitTransaction.Operation.RETURN;
        } else if (operation.equals((FruitTransaction.Operation.PURCHASE.getCode()) + COMMA)) {
            operationToAdd = FruitTransaction.Operation.PURCHASE;
        } else {
            throw new RuntimeException(
                    "Non-valid strategy");
        }
        putNewValue(string, operationToAdd);
    }
}
