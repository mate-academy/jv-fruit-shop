package core.basesyntex;

import core.basesyntex.io.FileReader;
import core.basesyntex.io.FileReaderImpl;
import core.basesyntex.io.FileWriter;
import core.basesyntex.io.FileWriterImpl;
import core.basesyntex.model.FruitTransaction;
import core.basesyntex.model.Operation;
import core.basesyntex.service.DataConverter;
import core.basesyntex.service.OperationHandler;
import core.basesyntex.service.ReportGenerator;
import core.basesyntex.service.ShopService;
import core.basesyntex.service.impl.BalanceOperationHandler;
import core.basesyntex.service.impl.DataConverterGetter;
import core.basesyntex.service.impl.PurchaseOperationHandler;
import core.basesyntex.service.impl.ReportGeneratorImpl;
import core.basesyntex.service.impl.ReturnOperationHandler;
import core.basesyntex.service.impl.ShopServiceImpl;
import core.basesyntex.service.impl.SupplyOperationHandler;
import core.basesyntex.strategy.OperationStrategy;
import core.basesyntex.strategy.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: Main <reportToReadFilePath> <finalReportFilePath>");
            return;
        }
        String reportToReadFilePath = args[0];
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read(reportToReadFilePath);
        DataConverter dataConverter = DataConverterGetter.getDataConverter();
        Map<Operation, OperationHandler> operationHandlers = Map.of(
                Operation.BALANCE, new BalanceOperationHandler(),
                Operation.PURCHASE, new PurchaseOperationHandler(),
                Operation.RETURN, new ReturnOperationHandler(),
                Operation.SUPPLY, new SupplyOperationHandler()
        );
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();
        String finalReportFilePath = args[1];
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, finalReportFilePath);
    }
}
