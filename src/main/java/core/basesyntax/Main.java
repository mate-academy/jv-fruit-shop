package core.basesyntax;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.FruitTransactionParserImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.OperationBalance;
import core.basesyntax.strategy.impl.OperationPurchase;
import core.basesyntax.strategy.impl.OperationReturn;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.OperationSupply;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String READ_FROM_FILE_PATH = "src/main/resources/input.csv";
    private static final String WRITE_TO_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationServiceMap = new HashMap<>();
        FruitStorageDao fruitStorageDao = new FruitStorageDaoImpl();
        operationServiceMap.put(FruitTransaction.Operation.BALANCE,
                new OperationBalance(fruitStorageDao));
        operationServiceMap.put(FruitTransaction.Operation.SUPPLY,
                new OperationSupply(fruitStorageDao));
        operationServiceMap.put(FruitTransaction.Operation.RETURN,
                new OperationReturn(fruitStorageDao));
        operationServiceMap.put(FruitTransaction.Operation.PURCHASE,
                new OperationPurchase(fruitStorageDao));

        FileReader reader = new FileReaderImpl();
        List<String> fromFile = reader.readFromFile(READ_FROM_FILE_PATH);
        for (String line : fromFile) {
            System.out.println(line);
        }
        System.out.println("=================");
        List<FruitTransaction> transactions =
                new FruitTransactionParserImpl().parseTransaction(fromFile);
        for (FruitTransaction t : transactions) {
            System.out.println(t);
        }
        System.out.println("=================");
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationServiceMap);
        FruitService fruitService = new FruitServiceImpl(operationStrategy);
        fruitService.doOperation(transactions);

        ReportGenerator generator = new ReportGeneratorImpl();
        String dataToWrite = generator.reportFromStorage(FruitStorage.storage);
        System.out.println(dataToWrite);

        FileWriter writer = new FileWriterImpl();
        writer.writeToFile(dataToWrite, WRITE_TO_FILE_PATH);
    }
}
