package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ReportCreatorService;
import core.basesyntax.service.impl.CsvReportCreatorServiceImpl;
import core.basesyntax.service.impl.FileReadServiceImpl;
import core.basesyntax.service.impl.FileWriteServiceImpl;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.strategy.OperationProcessor;
import core.basesyntax.strategy.impl.AddOperationProcessor;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.SubstractOperationProcessor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShop {
    private static final String STORAGE_FILE_NAME = "src/main/resources/storage.csv";
    private static final String REPORT_FILE_NAME = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        Map<Transaction.Operation, OperationProcessor> operationProcessMap = new HashMap<>();
        operationProcessMap.put(Transaction.Operation.BALANCE,
                new AddOperationProcessor(fruitDao));
        operationProcessMap.put(Transaction.Operation.SUPPLY,
                new AddOperationProcessor(fruitDao));
        operationProcessMap.put(Transaction.Operation.PURCHASE,
                new SubstractOperationProcessor(fruitDao));
        operationProcessMap.put(Transaction.Operation.RETURN,
                new AddOperationProcessor(fruitDao));
        FileReader reader = new FileReadServiceImpl();
        List<String> dataFromFile = reader.readData(STORAGE_FILE_NAME);
        List<Transaction> transactions = new TransactionParserImpl()
                .getTransactions(dataFromFile);
        FruitShopService fruitShopService
                = new FruitShopServiceImpl(new OperationStrategyImpl(operationProcessMap));
        fruitShopService.runTransaction(transactions);
        ReportCreatorService convertWriteDataService
                = new CsvReportCreatorServiceImpl(fruitDao);
        String report
                = convertWriteDataService.getReport();
        FileWriter fileWriteService = new FileWriteServiceImpl();
        fileWriteService.writeData(report, REPORT_FILE_NAME);
    }
}
