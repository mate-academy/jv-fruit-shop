package core.basesyntax;

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
import core.basesyntax.strategy.ReportGenerate;
import core.basesyntax.strategy.ReportGenerateImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        MyFileReader fileReader = new MyFileReaderImpl();
        List<String> inputReport = fileReader.read("src/main/java/core/basesyntax/report.csv");

        // 2. Convert the incoming data into FruitTransactions list
        DataConverter dataConverter = new DataConverterImpl();
        final List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        // 3. Create and feel the map with all OperationHandler implementations
        Map<FruitTransaction.Action, ActionHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Action.BALANCE, new BalanceAction());
        operationHandlers.put(FruitTransaction.Action.PURCHASE, new PurchaseAction());
        operationHandlers.put(FruitTransaction.Action.RETURN, new ReturnAction());
        operationHandlers.put(FruitTransaction.Action.SUPPLY, new SupplyAction());
        ActionStrategy operationStrategy = new ActionStrategyImpl(operationHandlers);

        // 4. Process the incoming transactions with applicable OperationHandler implementations
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        // 5.Generate report based on the current Storage state
        ReportGenerate reportGenerator = new ReportGenerateImpl();
        String resultingReport = reportGenerator.getReport();

        // 6. Write the received report into the destination file
        MyFileWriter fileWriter = new MyFileWriterImpl();
        fileWriter.write(resultingReport, "finalReport.csv");
    }
    // HINT: In the `public static void main(String[] args)` it is better to
    // and call their methods, but do not write any business logic in the `main` method!
}
