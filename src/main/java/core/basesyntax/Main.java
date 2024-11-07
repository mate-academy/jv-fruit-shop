package core.basesyntax;

import core.basesyntax.dao.fileReader;
import core.basesyntax.dao.fileReaderImpl;
import core.basesyntax.dao.writeReportImpl;
import core.basesyntax.model.Account;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.action.*;
import core.basesyntax.dao.writeReport;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static final Map<Account.Operation, ActionHandler> actionHandlerMap = new HashMap<>();
    private static fileReader fileReader = new fileReaderImpl();
    private static final String nameOfShopDatabase = "database.csv";
    private static final String nameOfFinalReport = "finalReport.csv";

    static ShopService shopService = new ShopServiceImpl();
    static writeReport writeReport = new writeReportImpl();
    public static void main(String[] arg) {
        String databaseInfo = "type,fruit,quantity\n" +
                "    b,banana,20\n" +
                "    b,apple,100\n" +
                "    s,banana,100\n" +
                "    p,banana,13\n" +
                "    r,apple,10\n" +
                "    p,apple,20\n" +
                "    p,banana,5\n" +
                "    s,banana,50";
        File directoryForDatabases = new File("directoryForDatabases");
        directoryForDatabases.mkdir();

        String filePathForDatabase = "directoryForDatabases" + File.separator + nameOfShopDatabase;
        String filePathForFinalReport = "directoryForDatabases" + File.separator + nameOfFinalReport;

        File fileForDatabase = new File(filePathForDatabase);
        File fileForFinalReport = new File(filePathForFinalReport);


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileForDatabase))) {
            fileForDatabase.createNewFile();
            fileForFinalReport.createNewFile();
            writer.write(databaseInfo);
        } catch (IOException e) {
            throw new RuntimeException("File was not created", e);
        }

        actionHandlerMap.put(Account.Operation.BALANCE, new BalanceAction());
        actionHandlerMap.put(Account.Operation.PURCHASE, new PurchaseAction());
        actionHandlerMap.put(Account.Operation.RETURN, new ReturnAction());
        actionHandlerMap.put(Account.Operation.SUPPLY, new SupplyAction());

        String[] textFromDatabase = fileReader.read(filePathForDatabase);
        shopService.generate(textFromDatabase);

        writeReport.writeReport(filePathForFinalReport);
    }
}