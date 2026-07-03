package core.basesyntax;

import core.converter.DataConverter;
import core.converter.DataConverterImpl;
import core.model.FruitTransaction;
import core.reader.FileReader;
import core.reader.FileReaderImpl;
import core.report.ReportGenerator;
import core.report.ReportGeneratorImpl;
import core.service.OperationStrategy;
import core.service.OperationStrategyImpl;
import core.service.ShopService;
import core.service.ShopServiceImpl;
import core.strategy.BalanceOperation;
import core.strategy.OperationHandler;
import core.strategy.PurchaseOperation;
import core.strategy.ReturnOperation;
import core.strategy.SupplyOperation;
import core.writer.FileWriter;
import core.writer.FileWriterImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read("src/main/resources/reportToRead.csv");

        DataConverter dataConverter = new DataConverterImpl();
        final List<FruitTransaction> transactions =
                dataConverter.convertToTransaction(inputReport);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());

        OperationStrategy operationStrategy =
                new OperationStrategyImpl(operationHandlers);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write("src/main/resources/finalReport.csv", resultingReport);
    }
}
