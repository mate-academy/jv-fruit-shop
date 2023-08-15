package core.basesyntax;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitTransactionHandler;
import core.basesyntax.service.ReportGenerateService;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.FruitTransactionParserImpl;
import core.basesyntax.service.impl.FruitTransactionsHandlerImpl;
import core.basesyntax.service.impl.ReportGenerateServiceImpl;
import java.util.List;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) {
        // Initialization
        FruitStorage storage = new FruitStorage();
        FileReader fileReader = new FileReaderImpl();
        TransactionParser transactionParser = new FruitTransactionParserImpl();

        // Processing
        List<String> transactionsStr = fileReader.readDataFromFile("data from File");
        List<FruitTransaction> transactionsFruitList = transactionParser
                .parseTransactions(transactionsStr);
        FruitTransactionHandler fruitTransactionsHandler =
                new FruitTransactionsHandlerImpl(storage);
        fruitTransactionsHandler.processTransactionsList(transactionsFruitList);

        //Generate report

        ReportGenerateService reportGenerateService = new ReportGenerateServiceImpl(storage);
        String generateReport = reportGenerateService.generateReport();

        //Writing report

        FileWriter writeReportToFile = new FileWriterImpl();
        writeReportToFile.writeReportToFile(generateReport, "data to file");

    }
}
