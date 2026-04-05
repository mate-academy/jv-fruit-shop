package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.strategy.BalanceHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseHandler;
import core.basesyntax.strategy.ReturnHandler;
import core.basesyntax.strategy.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();

        Map<FruitTransaction.Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(FruitTransaction.Operation.BALANCE, new BalanceHandler(storage));
        handlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler(storage));
        handlers.put(FruitTransaction.Operation.RETURN, new ReturnHandler(storage));
        handlers.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler(storage));

        OperationStrategy strategy = new OperationStrategyImpl(handlers);
        ShopService shopService = new ShopServiceImpl(strategy);

        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read("src/main/resources/reportToRead.csv");

        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convert(inputReport);

        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport(storage.getAll());

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, "src/main/resources/finalReport.csv");
    }
}
