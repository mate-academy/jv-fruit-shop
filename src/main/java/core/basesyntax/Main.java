package core.basesyntax;

import core.basesyntax.dao.CsvFileReader;
import core.basesyntax.dao.CsvFileReaderImpl;
import core.basesyntax.dao.CsvReportWriter;
import core.basesyntax.dao.CsvReportWriterImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransactionParser;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ActionStrategy;
import core.basesyntax.service.ActionStrategyImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.action.ActionHandler;
import core.basesyntax.service.action.BalanceAction;
import core.basesyntax.service.action.PurchaseAction;
import core.basesyntax.service.action.ReturnAction;
import core.basesyntax.service.action.SupplyAction;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Operation, ActionHandler> actionHandlerMap = Map.of(
            Operation.BALANCE, new BalanceAction(),
            Operation.PURCHASE, new PurchaseAction(),
            Operation.RETURN, new ReturnAction(),
            Operation.SUPPLY, new SupplyAction()
    );

    public static void main(String[] arg) {

        String filePathForDatabase = "src/main/directoryForDatabases/database.csv";
        String filePathForFinalReport = "src/main/directoryForDatabases/finalReport.csv";

        CsvFileReader fileReader = new CsvFileReaderImpl();
        String[] textFromDatabase = fileReader.read(filePathForDatabase);

        FruitTransactionParser fruitTransactionParser = new FruitTransactionParser();
        List<FruitTransaction> allTransactions = fruitTransactionParser
                .parseTransaction(textFromDatabase);

        ActionStrategy actionStrategy = new ActionStrategyImpl();
        ShopService shopService = new ShopServiceImpl(actionStrategy);
        shopService.generate(allTransactions);

        CsvReportWriter reportWriter = new CsvReportWriterImpl();
        reportWriter.generateReport(filePathForFinalReport);
    }
}
