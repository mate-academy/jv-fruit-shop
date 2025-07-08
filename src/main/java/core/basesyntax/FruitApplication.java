package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.fileservice.FileReader;
import core.basesyntax.service.fileservice.FileReaderImpl;
import core.basesyntax.service.fileservice.FileWriter;
import core.basesyntax.service.fileservice.FileWriterImpl;
import core.basesyntax.service.reportservice.DataConverter;
import core.basesyntax.service.reportservice.DataConverterImpl;
import core.basesyntax.service.reportservice.ReportGenerator;
import core.basesyntax.service.reportservice.ReportGeneratorImpl;
import core.basesyntax.service.shop.ShopService;
import core.basesyntax.service.shop.ShopServiceImpl;
import core.basesyntax.service.strategy.BalanceOperation;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.OperationStrategyImpl;
import core.basesyntax.service.strategy.PurchaseOperation;
import core.basesyntax.service.strategy.ReturnOperation;
import core.basesyntax.service.strategy.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitApplication {
    private static final String REPORT_TO_READ = "src/main/resources/reportToRead.csv";
    private static final String FINAL_REPORT = "src/main/resources/finalReport.csv";

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read(REPORT_TO_READ);
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, FINAL_REPORT);
    }
}
