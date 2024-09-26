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
import java.util.List;
import java.util.Map;

public class Main {
    static final String FROM_FILE = "src/main/resources/report.csv";
    static final String TO_FILE = "src/main/resources/new_report.csv";

    public static void main(String[] args) {
        MyFileReader fileReader = new MyFileReaderImpl();
        List<String> inputReport = fileReader.read(FROM_FILE);
        DataConverter dataConverter = new DataConverterImpl();
        final List<FruitTransaction> transactions = dataConverter
                .convertToTransactions(inputReport);
        Map<Action, ActionHandler> actionHandlers = Map.of(
                Action.BALANCE, new BalanceAction(),
                Action.PURCHASE, new PurchaseAction(),
                Action.RETURN, new ReturnAction(),
                Action.SUPPLY, new SupplyAction());
        ActionStrategy operationStrategy = new ActionStrategyImpl(actionHandlers);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);
        StorageReportGenerator reportGenerator = new StorageReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();
        MyFileWriter fileWriter = new MyFileWriterImpl();
        fileWriter.write(resultingReport, TO_FILE);
    }
}
