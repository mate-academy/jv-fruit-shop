package fruitshop;

import fruitshop.model.FruitTransaction;
import fruitshop.service.DataConverter;
import fruitshop.service.FileReaderService;
import fruitshop.service.FileWriterService;
import fruitshop.service.ReportGenerator;
import fruitshop.service.ShopService;
import fruitshop.service.impl.DataConverterImpl;
import fruitshop.service.impl.FileReaderServiceImpl;
import fruitshop.service.impl.FileWriterServiceImpl;
import fruitshop.service.impl.ReportGeneratorImpl;
import fruitshop.service.impl.ShopServiceImpl;
import fruitshop.strategy.BalanceOperationHandler;
import fruitshop.strategy.OperationHandler;
import fruitshop.strategy.OperationStrategy;
import fruitshop.strategy.OperationStrategyImpl;
import fruitshop.strategy.PurchaseOperationHandler;
import fruitshop.strategy.ReturnOperationHandler;
import fruitshop.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_INPUT_PATH = "src/main/resources/inputReport.csv";
    private static final String FILE_OUTPUT_PATH = "src/main/resources/outputReport.csv";
    private static List<FruitTransaction> transactions;

    public static void main(String[] args) {
        FileReaderService reader = new FileReaderServiceImpl();
        List<String> rawData = reader.read(FILE_INPUT_PATH);

        DataConverter converter = new DataConverterImpl();
        transactions = converter.convertToTransactions(rawData);

        Map<FruitTransaction.Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        handlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        handlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        handlers.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());

        OperationStrategy strategy = new OperationStrategyImpl(handlers);
        ShopService shopService = new ShopServiceImpl(strategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String report = reportGenerator.getReport();

        FileWriterService writer = new FileWriterServiceImpl();
        writer.write(report, FILE_OUTPUT_PATH);
    }
}
