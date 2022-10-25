package core.basesyntax;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.strategy.operation.impl.FruitService;
import java.util.List;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/resources/TransactionsPerDay.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/resources/DailyReport.csv";

    public static void main(String[] args) {
        List<String> data = new FileReaderServiceImpl().readFromFile(INPUT_FILE_NAME);
        List<Transaction> transactions = new TransactionParserImpl().parse(data);
        new FruitService().processTransaction(transactions);
        String report = new ReportServiceImpl().getReport();
        new FileWriterServiceImpl().writeToFile(report, OUTPUT_FILE_NAME);
    }
}
