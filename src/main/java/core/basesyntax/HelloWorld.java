package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileReaderImpl;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ReportContentGenerator;
import core.basesyntax.service.ReportWriter;
import core.basesyntax.strategy.BalanceHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseHandler;
import core.basesyntax.strategy.ReturnHandler;
import core.basesyntax.strategy.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelloWorld {

    private static final String INPUT_REPORT = "src/main/java/resources/reportToRead.csv";
    private static final String OUTPUT_REPORT = "src/main/java/resources/finalReport.csv";

    public static void main(String[] arg) {
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.processFile(INPUT_REPORT);

        DataConverter dataConverter = new DataConverter();
        final List<FruitTransaction> transactions =
                dataConverter.convertDataToTransactions(inputReport);

        Map<FruitTransaction.OperationType, OperationStrategy> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.OperationType.BALANCE, new BalanceHandler());
        operationHandlers.put(FruitTransaction.OperationType.PURCHASE, new PurchaseHandler());
        operationHandlers.put(FruitTransaction.OperationType.RETURN, new ReturnHandler());
        operationHandlers.put(FruitTransaction.OperationType.SUPPLY, new SupplyHandler());

        FruitShopService shopService = new FruitShopService(operationHandlers);
        shopService.processFile(transactions);

        ReportContentGenerator reportContentGenerator = new ReportContentGenerator();
        String resultingReport = reportContentGenerator.generateReportContent();

        ReportWriter reportWriter = new ReportWriter();
        reportWriter.writeReport(resultingReport, OUTPUT_REPORT);
    }
}
