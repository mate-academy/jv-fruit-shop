package core.basesyntax.service;

import core.basesyntax.dp.Report;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class DataProcessingService {
    private final CsvFileReaderServiceImpl readerService;
    private final CsvFileWriterServiceImpl writerService;
    private final Map<FruitTransaction.Operation, OperationHandler> operationToHandlerMap
            = new HashMap<>();

    public DataProcessingService() {
        initializationMap();
        readerService = new CsvFileReaderServiceImpl();
        writerService = new CsvFileWriterServiceImpl();
    }

    public void getDataProcessing(String readFile, String writeFile) {
        List<FruitTransaction> fruitTransactions = readerService.read(readFile);
        Map<String, List<FruitTransaction>> fruitToTransactions = fruitTransactions.stream()
                .collect(
                Collectors.groupingBy(
                        FruitTransaction::getFruit,
                        Collectors.toList()
                )
        );
        fruitToTransactions.forEach((fruit, transactions) -> {
            int sumOfQuantity = transactions.stream()
                    .mapToInt(this::getFruitResult)
                    .sum();
            Report.getFruitsQuantity().put(fruit, sumOfQuantity);
        });
        writerService.write(writeFile, Report.getFruitsQuantity());
    }

    private int getFruitResult(FruitTransaction fruitTransaction) {
        return Optional.ofNullable(operationToHandlerMap.get(fruitTransaction.getOperation()))
                .map(handler -> handler.getResultOfOperation(fruitTransaction.getQuantity()))
                .orElseThrow(() -> new IllegalArgumentException("Failed to get fruit result"));
    }

    private void initializationMap() {
        operationToHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler());
        operationToHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler());
        operationToHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationToHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler());
    }
}
