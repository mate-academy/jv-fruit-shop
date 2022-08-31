package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.FruitTransactionParserService;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.service.impl.FruitTransactionParserServiceImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.FruitBalanceHandler;
import core.basesyntax.strategy.impl.FruitPurchaseHandler;
import core.basesyntax.strategy.impl.FruitReturnHandler;
import core.basesyntax.strategy.impl.FruitSupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Runner {
    private static final String INPUT_FILE = "src/main/resources/fruitsBalance.csv";
    private static final String REPORT_FILE = "src/main/resources/reportAfterDay.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new FruitBalanceHandler(fruitDao));
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new FruitPurchaseHandler(fruitDao));
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new FruitReturnHandler(fruitDao));
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new FruitSupplyHandler(fruitDao));

        CsvFileReaderService readerService = new FileReaderServiceImpl();
        List<String> data = readerService.readData(INPUT_FILE);
        System.out.println("List of data: " + data);

        FruitTransactionParserService parserService = new FruitTransactionParserServiceImpl();
        List<FruitTransaction> transactions = parserService.parse(data);
        System.out.println("Parsed data: " + transactions);

        FruitService fruitService = new FruitServiceImpl(operationHandlerMap);
        fruitService.processTransactions(transactions);

        String report = fruitService.createReport();

        CsvFileWriterService csvWriterService = new WriterServiceImpl();
        csvWriterService.writeToFile(report, REPORT_FILE);
    }
}
