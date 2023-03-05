package core.basesyntax;

import core.basesyntax.db.StockBalance;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CalculateService;
import core.basesyntax.service.ProcessService;
import core.basesyntax.service.ReadService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriteService;
import core.basesyntax.service.impl.CalculateServiceImpl;
import core.basesyntax.service.impl.ProcessServiceImpl;
import core.basesyntax.service.impl.ReadServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriteServiceImpl;
import java.io.File;
import java.util.List;

public class Main {
    private static File csvReportFromFile = new File("src/main/resources/input.csv");
    private static String csvReportToFile = new String("src/main/resources/output.csv");

    public static void main(String[] args) {
        ReadService csvReadService = new ReadServiceImpl();
        List<String> fruitsListOperations = csvReadService.read(csvReportFromFile);
        ProcessService processServiceForReport = new ProcessServiceImpl();
        List<FruitTransaction> fruitsTransactionsList
                = processServiceForReport.create(fruitsListOperations);
        CalculateService calculateServiceForReport = new CalculateServiceImpl();
        calculateServiceForReport.create(fruitsTransactionsList);
        ReportService generateBalance = new ReportServiceImpl();
        String balance = generateBalance.get(StockBalance.STOCK_BALANCE);
        WriteService writeCsvReportToFile = new WriteServiceImpl();
        writeCsvReportToFile.write(balance, csvReportToFile);
    }
}
