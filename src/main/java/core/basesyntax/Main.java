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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static final Map<Operation, ActionHandler> actionHandlerMap = Map.of(
            Operation.BALANCE, new BalanceAction(),
            Operation.PURCHASE, new PurchaseAction(),
            Operation.RETURN, new ReturnAction(),
            Operation.SUPPLY, new SupplyAction()
    );

    public static void main(String[] arg) {

        String filePathForDatabase = "src/main/directoryForDatabases/database.csv";
        String filePathForFinalReport = "src/main/directoryForDatabases/finalReport.csv";

        String databaseInfo = "type,fruit,quantity\n"
                + "    b,banana,20\n"
                + "    b,apple,100\n"
                + "    s,banana,100\n"
                + "    p,banana,13\n"
                + "    r,apple,10\n"
                + "    p,apple,20\n"
                + "    p,banana,5\n"
                + "    s,banana,50";
        File directoryForDatabases = new File("directoryForDatabases");
        directoryForDatabases.mkdir();

        File fileForDatabase = new File(filePathForDatabase);
        File fileForFinalReport = new File(filePathForFinalReport);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileForDatabase))) {
            fileForDatabase.createNewFile();
            fileForFinalReport.createNewFile();
            writer.write(databaseInfo);
        } catch (IOException e) {
            throw new RuntimeException("File was not created", e);
        }

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
