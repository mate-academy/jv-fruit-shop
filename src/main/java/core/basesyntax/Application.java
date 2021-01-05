package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileReaderImpl;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FileWriterImpl;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;
import core.basesyntax.service.TransactionMapper;
import core.basesyntax.service.TransactionMapperImpl;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Application {
    private static String fineName = "src/main/resources/inputfile.csv";
    private static String reportFileName = "src/main/resources/fruitreport.csv";

    public static void main(String[] args) {
        Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(Operation.RETURN, new ReturnOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        FileReader fileReader = new FileReaderImpl();
        List<String> rows = fileReader.readFromFile(Path.of(fineName));
        TransactionMapper transactionMapper = new TransactionMapperImpl();
        List<Transaction> transactions = transactionMapper.stringsToTransactions(rows);
        FruitService fruitService = new FruitServiceImpl(operationStrategy);
        fruitService.createReport(transactions);
        List<String> reportToStrings = transactionMapper.storageToStrings(Storage.fruitStorage);
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeToFile(reportToStrings, reportFileName);
    }
}
