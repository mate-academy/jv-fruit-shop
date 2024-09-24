package core.basesyntax;

import core.basesyntax.model.Action;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.report.StorageReportGenerator;
import core.basesyntax.report.StorageReportGeneratorImpl;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final String fromFile = "src/main/resources/report.csv";
        final String toFile = "src/main/resources/new_report.csv";
        MyFileReader fileReader = new MyFileReaderImpl();
        List<String> inputReport = fileReader.read(fromFile);
        DataConverter dataConverter = new DataConverterImpl();
        final List<FruitTransaction> transactions = dataConverter
                .convertToTransactions(inputReport);
        Map<Action, ActionHandler> actionHandlers = new HashMap<>();
        actionHandlers.put(Action.BALANCE, new BalanceAction());
        actionHandlers.put(Action.PURCHASE, new PurchaseAction());
        actionHandlers.put(Action.RETURN, new ReturnAction());
        actionHandlers.put(Action.SUPPLY, new SupplyAction());
        ActionStrategy operationStrategy = new ActionStrategyImpl(actionHandlers);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);
        StorageReportGenerator reportGenerator = new StorageReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();
        MyFileWriter fileWriter = new MyFileWriterImpl();
        fileWriter.write(resultingReport, toFile);
    }
}
