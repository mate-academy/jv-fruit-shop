package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.db.StorageImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.converter.DataConverter;
import core.basesyntax.service.converter.DataConverterImpl;
import core.basesyntax.service.reader.ReadFileFruit;
import core.basesyntax.service.reader.ReadFileFruitImpl;
import core.basesyntax.service.report.ReportGenerator;
import core.basesyntax.service.report.ReportGeneratorImpl;
import core.basesyntax.service.shop.ShopService;
import core.basesyntax.service.shop.ShopServiceImpl;
import core.basesyntax.service.strategy.BalanceFruitTransactionHandler;
import core.basesyntax.service.strategy.FruitTransactionHandler;
import core.basesyntax.service.strategy.FruitTransactionStrategy;
import core.basesyntax.service.strategy.FruitTransactionStrategyImpl;
import core.basesyntax.service.strategy.PurchaseFruitTransactionHandler;
import core.basesyntax.service.strategy.ReturnFruitTransactionHandler;
import core.basesyntax.service.strategy.SupplyFruitTransactionHandler;
import core.basesyntax.service.writer.WriteFileFruit;
import core.basesyntax.service.writer.WriteFileFruitImpl;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FROM_FILE_CSV = "src/main/resources/reportToRead.csv";
    private static final String TO_FILE_CSV = "src/main/resources/finalReport.csv";

    public static void main(String[] arg) {
        Map<String, Integer> map = new LinkedHashMap<>();
        Storage storage = new StorageImpl(map);
        ReadFileFruit fileReader = new ReadFileFruitImpl();
        List<String> inputReport = fileReader.readAll(FROM_FILE_CSV);
        DataConverter dataConverter = new DataConverterImpl();
        Map<Operation, FruitTransactionHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(Operation.BALANCE, new BalanceFruitTransactionHandler(storage));
        operationHandlers.put(Operation.PURCHASE, new PurchaseFruitTransactionHandler(storage));
        operationHandlers.put(Operation.RETURN, new ReturnFruitTransactionHandler(storage));
        operationHandlers.put(Operation.SUPPLY, new SupplyFruitTransactionHandler(storage));
        FruitTransactionStrategy operationStrategy
                = new FruitTransactionStrategyImpl(operationHandlers);
        List<FruitTransaction> transactions = dataConverter.convertAll(inputReport);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);
        ReportGenerator reportGenerator = new ReportGeneratorImpl(storage);
        String resultingReport = reportGenerator.getReport();
        WriteFileFruit fileWriter = new WriteFileFruitImpl();
        fileWriter.writeAll(resultingReport, TO_FILE_CSV);
    }
}
