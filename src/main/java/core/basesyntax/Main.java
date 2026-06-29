package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.DataConverter;
import service.FileReader;
import service.FileWriter;
import service.ReportGenerator;
import service.ShopService;
import service.impl.DataConverterImpl;
import service.impl.FileReaderImpl;
import service.impl.FileWriterImpl;
import service.impl.ReportGeneratorImpl;
import service.impl.ShopServiceImpl;
import strategy.BalanceOperation;
import strategy.OperationHandler;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;
import strategy.PurchaseOperation;
import strategy.ReturnOperation;
import strategy.SupplyOperation;

public class Main {
    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read("reportToRead.csv");

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
        fileWriter.write(resultingReport, "finalReport.csv");
    }
}

