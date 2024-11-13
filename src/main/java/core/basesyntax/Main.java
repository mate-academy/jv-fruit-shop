package core.basesyntax;

import core.basesyntax.dao.FileCreator;
import core.basesyntax.dao.FileReader;
import core.basesyntax.dao.FileReaderImpl;
import core.basesyntax.dao.ReportWriter;
import core.basesyntax.dao.ReportWriterImpl;
import core.basesyntax.model.Account;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.action.ActionHandler;
import core.basesyntax.service.action.BalanceAction;
import core.basesyntax.service.action.PurchaseAction;
import core.basesyntax.service.action.ReturnAction;
import core.basesyntax.service.action.SupplyAction;
import java.util.Map;

public class Main {
    public static final Map<Account.Operation, ActionHandler> actionHandlerMap = Map.of(
            Account.Operation.BALANCE, new BalanceAction(),
            Account.Operation.PURCHASE, new PurchaseAction(),
            Account.Operation.RETURN, new ReturnAction(),
            Account.Operation.SUPPLY, new SupplyAction()
    );

    private static FileReader fileReader = new FileReaderImpl();
    private static ReportWriter reportWriter = new ReportWriterImpl();
    private static ShopService shopService = new ShopServiceImpl();
    private static Fruit apple = new Fruit();
    private static Fruit banana = new Fruit();
    private static FileCreator fileCreator = new FileCreator();

    public static Fruit getApple() {
        return apple;
    }

    public static Fruit getBanana() {
        return banana;
    }

    public static void main(String[] arg) {
        fileCreator.createAllFiles();
        String filePathForDatabase = "src/main/directoryForDatabases/database.csv";
        String filePathForFinalReport = "src/main/directoryForDatabases/finalReport.csv";

        String[] textFromDatabase = fileReader.read(filePathForDatabase);
        shopService.generate(textFromDatabase);

        reportWriter.writeReport(filePathForFinalReport);
    }
}
