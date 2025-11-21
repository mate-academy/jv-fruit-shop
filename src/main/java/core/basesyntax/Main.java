package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.CsvReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseHandler;
import core.basesyntax.strategy.impl.SupplyAndReturnHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();
        CsvReader reader = new CsvReaderImpl();
        List<String> data = reader.readAll("src/main/resources/data.csv");

        Parser parser = new ParserImpl();
        final List<FruitTransaction> fruitTransactions = parser.parse(data);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new SupplyAndReturnHandler());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyAndReturnHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        ShopService shopService = new ShopServiceImpl(storage,operationStrategy);
        shopService.process(fruitTransactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl(storage);
        String report = reportGenerator.getReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeReport(report,"src/main/resources/report.csv");
    }
}
