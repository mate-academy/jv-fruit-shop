package fruitshop;

import fruitshop.model.FruitTransaction;
import fruitshop.service.ParserService;
import fruitshop.service.ReaderService;
import fruitshop.service.ReportGenerator;
import fruitshop.service.ShopService;
import fruitshop.service.WriterService;
import fruitshop.service.impl.ParserServiceImpl;
import fruitshop.service.impl.ReaderServiceImpl;
import fruitshop.service.impl.ReportGeneratorImpl;
import fruitshop.service.impl.ShopServiceImpl;
import fruitshop.service.impl.WriterServiceImpl;
import fruitshop.strategy.OperationHandler;
import fruitshop.strategy.OperationStrategy;
import fruitshop.strategy.impl.BalanceOperationHandler;
import fruitshop.strategy.impl.OperationStrategyImpl;
import fruitshop.strategy.impl.PurchaseOperationHandler;
import fruitshop.strategy.impl.ReturnOperationHandler;
import fruitshop.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // 1. Set up operation handlers
        Map<FruitTransaction.Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        handlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        handlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        handlers.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());

        // 2. Read data from the input file
        ReaderService reader = new ReaderServiceImpl();
        List<String> data = reader.readFromFile("src/main/resources/reportToRead.csv");

        // 3. Parse the data into FruitTransactions
        ParserService parser = new ParserServiceImpl();
        List<FruitTransaction> transactions = parser.parse(data);

        // 4. Set up strategy
        OperationStrategy operationStrategy = new OperationStrategyImpl(handlers);

        // 5. Process transactions
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        // 6. Generate report based on final fruit quantities
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String report = reportGenerator.generate();

        // 7. Write the report to an output file
        WriterService writer = new WriterServiceImpl();
        writer.write(report, "src/main/resources/finalReport.csv");
    }
}
