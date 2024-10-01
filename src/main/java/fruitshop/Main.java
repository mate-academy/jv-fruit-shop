package fruitshop;

import fruitshop.model.FruitTransaction;
import fruitshop.service.DataConverter;
import fruitshop.service.FileReader;
import fruitshop.service.FileWriter;
import fruitshop.service.ReportGenerator;
import fruitshop.service.ShopService;
import fruitshop.service.impl.DataConverterImpl;
import fruitshop.service.impl.FileReaderImpl;
import fruitshop.service.impl.FileWriterImpl;
import fruitshop.service.impl.ReportGeneratorImpl;
import fruitshop.service.impl.ShopServiceImpl;
import fruitshop.strategy.BalanceOperation;
import fruitshop.strategy.OperationHandler;
import fruitshop.strategy.OperationStrategy;
import fruitshop.strategy.OperationStrategyImpl;
import fruitshop.strategy.PurchaseOperation;
import fruitshop.strategy.ReturnOperation;
import fruitshop.strategy.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] arg) {
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read("src/main/resources/reportToRead.csv");

        DataConverter dataConverter = new DataConverterImpl();
        final List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, "src/main/resources/finalReport.csv");
    }
}
