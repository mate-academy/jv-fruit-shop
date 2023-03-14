package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionService;
import java.util.List;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/resources/data.csv";
    private static final String REPORT_FILE_NAME = "src/main/resources/report.csv";

    public static void main(String[] args) {
        List<String> dataFromFile = FileReaderService.readFromFile(INPUT_FILE_NAME);
        ParserService parserService = new ParserService();
        List<FruitTransaction> listFruitTransactions =
                parserService.convertToListFruitTransaction(dataFromFile);
        TransactionService transactionService = new TransactionService();
        transactionService.processing(listFruitTransactions);
        ReportService reportService = new ReportService();
        FileWriterService.writeToFile(REPORT_FILE_NAME, reportService.generateReport());
    }
}
