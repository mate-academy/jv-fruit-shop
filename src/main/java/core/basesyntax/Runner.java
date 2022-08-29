package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvWriterService;
import core.basesyntax.service.FruitDataParserService;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.serviceimpl.CsvFileReaderServiceImpl;
import core.basesyntax.service.serviceimpl.CsvWriterServiceImpl;
import core.basesyntax.service.serviceimpl.FruitDataParserImpl;
import core.basesyntax.service.serviceimpl.FruitServiceImpl;
import core.basesyntax.strategy.strategyimpl.FruitBalanceHandler;
import core.basesyntax.strategy.strategyimpl.FruitPurchaseHandler;
import core.basesyntax.strategy.strategyimpl.FruitReturnHandler;
import core.basesyntax.strategy.strategyimpl.FruitSupplyHandler;
import core.basesyntax.strategy.strategyimpl.OperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Runner {
    private static final String INPUT_FILE = "fruitsBalance.csv";
    private static final String REPORT_FILE = "reportAfterDay.csv";

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

        CsvFileReaderService readerService = new CsvFileReaderServiceImpl();
        List<String> data = readerService.readData(INPUT_FILE);
        System.out.println("List of data: " + data);

        FruitDataParserService parserService = new FruitDataParserImpl();
        List<FruitTransaction> transactions = parserService.parse(data);
        System.out.println("Parsed data: " + transactions);

        FruitService fruitService = new FruitServiceImpl(operationHandlerMap);
        fruitService.processTransactions(transactions);

        String report = fruitService.createReport(transactions);

        CsvWriterService csvWriterService = new CsvWriterServiceImpl();
        csvWriterService.writeToFile(report, REPORT_FILE);
    }
}
