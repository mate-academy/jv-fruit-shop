package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.service.OperatorService;
import core.basesyntax.model.service.ParserService;
import core.basesyntax.model.service.ReaderService;
import core.basesyntax.model.service.ReportService;
import core.basesyntax.model.service.WriterService;
import core.basesyntax.model.service.impl.OperatorServiceImpl;
import core.basesyntax.model.service.impl.ParserServiceImpl;
import core.basesyntax.model.service.impl.ReaderServiceImpl;
import core.basesyntax.model.service.impl.ReportServiceImpl;
import core.basesyntax.model.service.impl.WriterServiceImpl;
import java.util.List;

public class Main {
    private static final String DATA_FILE_PATH = "src/main/resources/input.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        final ReaderService readerService = new ReaderServiceImpl();
        List<String> lines = readerService.readFile(DATA_FILE_PATH);

        final ParserService transactionService = new ParserServiceImpl();
        List<FruitTransaction> transactions = transactionService.parseTransaction(lines);

        final OperatorService fruitService = new OperatorServiceImpl();
        fruitService.operateTransactions(transactions);

        final ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport();

        final WriterService writerService = new WriterServiceImpl();
        writerService.writeReport(REPORT_FILE_PATH, report);
    }
}
