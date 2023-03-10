package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.ReportGeneration;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ReportGenerationImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.OperationHandlerImplBalance;
import core.basesyntax.strategy.impl.OperationHandlerImplPurchase;
import core.basesyntax.strategy.impl.OperationHandlerImplReturn;
import core.basesyntax.strategy.impl.OperationHandlerImplStrategy;
import core.basesyntax.strategy.impl.OperationHandlerImplSupply;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final String writeFrom = "src/main/resourses/input.csv";
        final String writeTo = "src/main/resourses/result.csv";
        /* Create Strategy Map */
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("b", new OperationHandlerImplBalance());
        operationHandlerMap.put("p", new OperationHandlerImplPurchase());
        operationHandlerMap.put("r", new OperationHandlerImplReturn());
        operationHandlerMap.put("s", new OperationHandlerImplSupply());

        /* Read data from csv file */
        FileReader getDataBase = new FileReaderImpl();
        List<String> list = getDataBase.readFromFile(writeFrom);

        /* Insert data to Transactions */
        TransactionParser transactionParser = new TransactionParserImpl();
        List transactions = transactionParser.transactionParser(list);

        /* Insert data to Storage with counting */
        TransactionService insertDataToBase =
                new TransactionServiceImpl(new OperationHandlerImplStrategy(operationHandlerMap));
        insertDataToBase.addTransferToStorage(transactions);

        /* Generate report */
        ReportGeneration reportGeneration = new ReportGenerationImpl();
        String report = reportGeneration.generateReport(Storage.fruits);

        /* Write result to csv file */
        core.basesyntax.service.FileWriter writeDataToFile = new FileWriterImpl();
        writeDataToFile.writeDataToFile(report, writeTo);
    }
}
