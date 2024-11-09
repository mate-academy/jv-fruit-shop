package core.basesyntax;

import core.basesyntax.dao.FileCreator;
import core.basesyntax.dao.ReadFile;
import core.basesyntax.dao.ReadFileImpl;
import core.basesyntax.dao.WriteReport;
import core.basesyntax.dao.WriteReportImpl;
import core.basesyntax.model.Account;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.action.ActionHandler;
import core.basesyntax.service.action.BalanceAction;
import core.basesyntax.service.action.PurchaseAction;
import core.basesyntax.service.action.ReturnAction;
import core.basesyntax.service.action.SupplyAction;
import java.io.File;
import java.util.Map;

public class Main {
    public static final Map<Account.Operation, ActionHandler> actionHandlerMap = Map.of(
            Account.Operation.BALANCE, new BalanceAction(),
            Account.Operation.PURCHASE, new PurchaseAction(),
            Account.Operation.RETURN, new ReturnAction(),
            Account.Operation.SUPPLY, new SupplyAction()
    );
    private static final String nameOfShopDatabase = "database.csv";
    private static final String nameOfFinalReport = "finalReport.csv";
    private static ReadFile fileReader = new ReadFileImpl();

    private static ShopService shopService = new ShopServiceImpl();
    private static WriteReport writeReport = new WriteReportImpl();
    private static FileCreator fileCreator = new FileCreator();

    public static void main(String[] arg) {
        fileCreator.createAllFiles();
        String filePathForDatabase = "src/main"
                + File.separator + nameOfShopDatabase;
        String filePathForFinalReport = "src/main"
                + File.separator + nameOfFinalReport;

        String[] textFromDatabase = fileReader.read(filePathForDatabase);
        shopService.generate(textFromDatabase);

        writeReport.writeReport(filePathForFinalReport);
    }
}
