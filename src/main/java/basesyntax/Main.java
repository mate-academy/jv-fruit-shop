package basesyntax;

import basesyntax.model.FruitTransaction;
import basesyntax.service.DataConverter;
import basesyntax.service.FileReader;
import basesyntax.service.OperationHandler;
import basesyntax.service.ReportGenerator;
import basesyntax.service.ShopService;
import basesyntax.service.impl.DataConverterImpl;
import basesyntax.service.impl.FileReaderImpl;
import basesyntax.service.impl.ReportGeneratorImpl;
import basesyntax.service.impl.ShopServiceImpl;
import basesyntax.strategy.BalanceOperation;
import basesyntax.strategy.OperationStrategy;
import basesyntax.strategy.OperationStrategyImpl;
import basesyntax.strategy.PurchaseOperation;
import basesyntax.strategy.ReturnOperation;
import basesyntax.strategy.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileReader reader = new FileReaderImpl();
        List<String> lines = reader.read("src/main/resources/input.csv");

        DataConverter converter = new DataConverterImpl();
        List<FruitTransaction> transactions = converter.convertToTransaction(lines);

        Map<FruitTransaction.Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        handlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        handlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        handlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());

        OperationStrategy strategy = new OperationStrategyImpl(handlers);
        ShopService shopService = new ShopServiceImpl(strategy);
        Map<String, Integer> result = shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        System.out.println(reportGenerator.generate(result));
    }
}
