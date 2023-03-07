package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CalculateService;
import core.basesyntax.service.ReadService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.WriteService;
import core.basesyntax.service.impl.CalculateServiceImpl;
import core.basesyntax.service.impl.ReadServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.service.impl.WriteServiceImpl;
import core.basesyntax.strategy.OperationHandlerStrategy;
import java.io.File;
import java.util.List;

public class Main {
    private static final String OPERATIONS_FILE = "src/main/resources/input.csv";
    private static final String REPORT_FILE = "src/main/resources/output.csv";

    public static void main(String[] args) {
        ReadService readService = new ReadServiceImpl();
        List<String> fruitsOperations = readService.read(new File(OPERATIONS_FILE));
        TransactionParser parser = new TransactionParserImpl();
        List<FruitTransaction> fruitsTransactions
                = parser.parse(fruitsOperations);
        CalculateService calculateServiceReport
                = new CalculateServiceImpl(new OperationHandlerStrategy());
        calculateServiceReport.put(fruitsTransactions);
        ReportService reportService = new ReportServiceImpl(Storage.STOCK_BALANCE);
        String report = reportService.getReport();
        WriteService writeService = new WriteServiceImpl();
        writeService.write(report, REPORT_FILE);
    }
}
