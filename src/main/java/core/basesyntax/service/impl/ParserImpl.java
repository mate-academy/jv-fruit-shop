package core.basesyntax.service.impl;

import core.basesyntax.db.StorageDao;
import core.basesyntax.db.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationExecution;
import core.basesyntax.service.Parser;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.operationhandlers.BalanceOperationHandler;
import core.basesyntax.strategy.operationhandlers.OperationHandler;
import core.basesyntax.strategy.operationhandlers.PurchaseOperationHandler;
import core.basesyntax.strategy.operationhandlers.ReturnOperationHandler;
import core.basesyntax.strategy.operationhandlers.SupplyOperationHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParserImpl implements Parser {
    public static final Map<FruitTransaction.Operation,
            OperationHandler> OPERATION_HANDLER_MAP = Map.of(
            FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(),
            FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler(),
            FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(),
            FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
    public static final String WORD_SEPARATOR = ",";
    public static final String LINE_SEPARATOR = "\n";

    @Override
    public String parse(List<String> data) {
        OperationStrategy operationStrategy = new OperationStrategyImpl(OPERATION_HANDLER_MAP);
        OperationExecution operationExecution = new OperationExecutionImpl(new StorageDaoImpl(),
                operationStrategy);

        List<FruitTransaction> fruitTransactionData = convertToFruitTransaction(data);

        List<String> fruits = new ArrayList<>();
        for (FruitTransaction fruitTransaction : fruitTransactionData) {
            operationExecution.execute(fruitTransaction);
            fruits.add(fruitTransaction.getFruit());
        }
        return createReport(fruits);
    }

    private List<FruitTransaction> convertToFruitTransaction(List<String> data) {
        return data.stream()
                .filter(line -> line.startsWith("b")
                        || line.startsWith("s")
                        || line.startsWith("p")
                        || line.startsWith("r"))
                .map(this::getFromCsvRow)
                .collect(Collectors.toList());
    }

    private FruitTransaction getFromCsvRow(String line) {
        String[] fields = line.split(WORD_SEPARATOR);
        FruitTransaction fruitTransaction = new FruitTransaction();
        FruitTransaction.Operation operation = FruitTransaction.Operation.BALANCE;
        operation = operation.getOperationFromLetter(fields[0]);
        fruitTransaction.setOperation(operation);
        fruitTransaction.setFruit(fields[1]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[2]));
        return fruitTransaction;
    }

    private String createReport(List<String> fruits) {
        StorageDao storageDao = new StorageDaoImpl();
        fruits = fruits.stream()
                .distinct()
                .map(fruit -> {
                    if (storageDao.get(fruit).getQuantity() < 0) {
                        throw new RuntimeException("Balance should be positive: "
                                + fruit
                                + ","
                                + storageDao.get(fruit).getQuantity());
                    } else {
                        return fruit;
                    }
                }).collect(Collectors.toList());
        StringBuilder report = new StringBuilder("fruit,quantity");
        fruits.forEach(fruit -> {
            report.append(LINE_SEPARATOR);
            report.append(fruit);
            report.append(WORD_SEPARATOR);
            report.append(storageDao.get(fruit).getQuantity());
        });
        return report.toString();
    }
}
