package core.basesyntax;

import core.basesyntax.OpationStrategy.OperationHandler;
import core.basesyntax.OpationStrategy.OperationStrategy;
import core.basesyntax.OpationStrategy.OperationStrategyImpl;
import core.basesyntax.Operations.*;
import core.basesyntax.ShopServiceAndReportGenerator.ReportGenerator;
import core.basesyntax.ShopServiceAndReportGenerator.ReportGeneratorImpl;
import core.basesyntax.ShopServiceAndReportGenerator.ShopService;
import core.basesyntax.ShopServiceAndReportGenerator.ShopServiceImpl;
import core.basesyntax.WorkWithFile.DataConverterImpl;
import core.basesyntax.WorkWithFile.FileReaderImpl;
import core.basesyntax.WorkWithFile.FileWriterImpl;
import core.basesyntax.WorkWithFileInterface.DataConverter;
import core.basesyntax.WorkWithFileInterface.FileDataReader;
import core.basesyntax.WorkWithFileInterface.FileWriter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileDataReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read("IDontKnowFileName.csv");

        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport(shopService.getStorage());

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, "finalReport.csv");

        System.out.println("Report is done and wrote to the finalReport.csv");
    }
}
