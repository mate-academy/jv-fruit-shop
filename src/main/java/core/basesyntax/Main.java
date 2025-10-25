package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.impl.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_TO_READ = "src/main/resources/dailyActivities.csv";
    private static final String FILE_TO_WRITE = "src/main/resources/finalReport.csv";

    public static void main(String[] args) {
        //read CSV file
        FileReader fileReader = new FileReaderImpl();
        List<String> fileContent = fileReader.read(FILE_TO_READ);

        //setup storage and handlers
        StorageDao storageDao = new StorageDaoImpl();
        Map<FruitTransaction.Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(storageDao));
        handlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler(storageDao));
        handlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(storageDao));
        handlers.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler(storageDao));

        //convert lines to transactions
        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions =
                dataConverter.convertToTransaction(fileContent);

        //process transactions
        OperationStrategy operationStrategy = new OperationStrategyImpl(handlers);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        //generate report
        ReportGenerator reportGenerator = new ReportGeneratorImpl(storageDao);
        String finalReport = reportGenerator.getReport();

        //write report to CSV file
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(FILE_TO_WRITE, finalReport);
    }
}
