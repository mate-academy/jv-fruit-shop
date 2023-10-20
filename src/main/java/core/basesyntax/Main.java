package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileParser;
import core.basesyntax.service.FileService;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.CsvFileParserImpl;
import core.basesyntax.service.impl.FileServiceImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.FruitTransactionServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.TransactionStrategy;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import core.basesyntax.strategy.impl.TransactionStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "inputData.csv";
    private static final String OUTPUT_FILE = "outputData.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        FruitService fruitService = new FruitServiceImpl(fruitDao);
        fruitService.createFruit("banana");
        fruitService.createFruit("apple");

        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler());

        TransactionStrategy strategy =
                new TransactionStrategyImpl(operationHandlerMap);

        FileParser fileParser = new CsvFileParserImpl();
        FileService fileService = new FileServiceImpl(fileParser);

        FruitTransactionService fruitTransactionService =
                new FruitTransactionServiceImpl(fruitDao, strategy);

        for (FruitTransaction fruitTransaction
                : fileService.readFile(INPUT_FILE)) {
            fruitTransactionService.transaction(fruitTransaction);
        }

        ReportService reportService = new ReportServiceImpl(fruitDao);

        List<String> report = reportService.createReport();

        StringBuilder reportData = new StringBuilder();

        for (String line : report) {
            reportData.append(line).append("\n");
        }

        fileService.writeToFile(OUTPUT_FILE, reportData.toString());
    }

}
