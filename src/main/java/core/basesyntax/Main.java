package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ParseService;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ParseServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceOperationHandlerImpl;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandlerImpl;
import core.basesyntax.strategy.impl.SupplyOperationHandlerImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/database.csv";
    private static final String FILE_REPORT_PATH = "src/main/resources/fileReport.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandlerImpl());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandlerImpl());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandlerImpl());

        FileReader reader = new FileReaderImpl();
        List<String> dataFromFile = reader.readFromFile(INPUT_FILE);
        System.out.println(dataFromFile);

        ParseService parseService = new ParseServiceImpl();
        List<FruitTransaction> transactions = parseService.parseTransaction(dataFromFile);
        System.out.println(transactions.toString());

        TransactionService transactionService = new TransactionServiceImpl(
                new OperationStrategyImpl(operationHandlerMap));
        transactionService.addOperationToStorage(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String report = reportGenerator.generateReport();

        FileWriter write = new FileWriterImpl();
        write.writeToFile(FILE_REPORT_PATH, report);
    }
}
