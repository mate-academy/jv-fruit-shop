package core.basesyntax;

import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.service.impl.FruitFileReaderImpl;
import core.basesyntax.service.impl.FruitFileSaverImpl;
import core.basesyntax.service.impl.FruitRawStringParserImpl;
import core.basesyntax.service.impl.FruitReportCreateImpl;
import core.basesyntax.service.interfaces.FruitFileReader;
import core.basesyntax.service.interfaces.FruitRawStringParser;
import core.basesyntax.service.interfaces.FruitReportCreate;
import core.basesyntax.service.strategy.FruitStrategy;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.impl.BalanceOperation;
import core.basesyntax.service.strategy.impl.PurchaseOperation;
import core.basesyntax.service.strategy.impl.ReturnOperation;
import core.basesyntax.service.strategy.impl.SupplyOperation;
import java.util.List;

public class Main {
    private static String fileOpen = "src/main/resources/fruitts.csv";
    //    private static String fileOpen = "src/main/resources/fruitsWithNulls.csv";
    private static String fileSave = "src/main/resources/report.csv";
    private static StorageDaoImpl actionDB = new StorageDaoImpl();

    public static void main(String[] args) {
        FruitFileReader reader = new FruitFileReaderImpl();
        List<String> fileString = reader.readFile(fileOpen);
        FruitRawStringParser parser = new FruitRawStringParserImpl();
        var readerService = parser.parsedFruitData(fileString);
        System.out.println(readerService);
        var balance = new BalanceOperation(actionDB);
        var supply = new SupplyOperation(actionDB);
        var returns = new ReturnOperation(actionDB);
        var purchase = new PurchaseOperation(actionDB);
        List<OperationHandler> handlers = List.of(balance,returns,purchase,supply);
        FruitStrategy strategy = new FruitStrategy(handlers);
        for (var dto : readerService) {
            strategy.getHandlers(dto).forEach(oh -> oh.apply(dto));
        }
        FruitReportCreate prapareReport = new FruitReportCreateImpl();
        String report = prapareReport.createReport(Storage.fruitsQuantity);
        System.out.println(report);
        FruitFileSaverImpl saver = new FruitFileSaverImpl();
        saver.saveToFile(report,fileSave);
    }
}
