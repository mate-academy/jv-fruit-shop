package core.basesyntax;

import core.basesyntax.model.Action;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ActionHandler;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.impl.BalanceAction;
import core.basesyntax.service.impl.PurchaseAction;
import core.basesyntax.service.impl.ReturnAction;
import core.basesyntax.service.impl.SupplyAction;
import core.basesyntax.strategy.ActionStrategy;
import core.basesyntax.strategy.ActionStrategyImpl;
import core.basesyntax.strategy.DataConverter;
import core.basesyntax.strategy.DataConverterImpl;
import core.basesyntax.strategy.MyFileReader;
import core.basesyntax.strategy.MyFileReaderImpl;
import core.basesyntax.strategy.MyFileWriter;
import core.basesyntax.strategy.MyFileWriterImpl;
import core.basesyntax.strategy.StorageReportGenerate;
import core.basesyntax.strategy.StorageReportGenerateImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        MyFileReader fileReader = new MyFileReaderImpl();
        List<String> inputReport = fileReader.read("src/main/resources/report.csv");
        // 2. Convert the incoming data into FruitTransactions list
        DataConverter dataConverter = new DataConverterImpl();
        final List<FruitTransaction> transactions = dataConverter
                .convertToTransactions(inputReport);
        // 3. Create and feel the map with all OperationHandler implementations
        Map<Action, ActionHandler> actionHandlers = new HashMap<>();
        actionHandlers.put(Action.BALANCE, new BalanceAction());
        actionHandlers.put(Action.PURCHASE, new PurchaseAction());
        actionHandlers.put(Action.RETURN, new ReturnAction());
        actionHandlers.put(Action.SUPPLY, new SupplyAction());
        ActionStrategy operationStrategy = new ActionStrategyImpl(actionHandlers);
        // 4. Process the incoming transactions with applicable OperationHandler implementations
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);
        // 5.Generate report based on the current Storage state
        StorageReportGenerate reportGenerator = new StorageReportGenerateImpl();
        String resultingReport = reportGenerator.getReport();
        // 6. Write the received report into the destination file
        MyFileWriter fileWriter = new MyFileWriterImpl();
        fileWriter.write(resultingReport, "src/main/resources/new_report.csv");
    }
    // HINT: In the `public static void main(String[] args)` it is better to
    // and call their methods, but do not write any business logic in the `main` method!
}
