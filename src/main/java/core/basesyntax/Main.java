package core.basesyntax;

import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.service.interfaces.FruitFileReader;
import core.basesyntax.service.interfaces.FruitRawStringParser;
import core.basesyntax.service.interfaces.FruitReportCreate;
import core.basesyntax.service.serviceimpl.FruitFileReaderImpl;
import core.basesyntax.service.serviceimpl.FruitFileSaverImpl;
import core.basesyntax.service.serviceimpl.FruitRawStringParserImpl;
import core.basesyntax.service.serviceimpl.FruitReportCreateImpl;
import core.basesyntax.service.strategy.FruitStrategy;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.strategyimpl.BalanceOperation;
import core.basesyntax.service.strategy.strategyimpl.PurchaseOperation;
import core.basesyntax.service.strategy.strategyimpl.ReturnOperation;
import core.basesyntax.service.strategy.strategyimpl.SupplyOperation;
import java.util.List;

public class Main {
    private static final String OPEN_FROM_FILE = "src/main/resources/fruitts.csv";
    //    private static final String OPEN_FROM_FILE = "src/main/resources/fruitsWithNulls.csv";
    private static final String SAVE_TO_FILE = "src/main/resources/report.csv";
    private static StorageDaoImpl actionDB = new StorageDaoImpl();

    public static void main(String[] args) {
        FruitFileReader reader = new FruitFileReaderImpl();
        List<String> fileString = reader.readFile(OPEN_FROM_FILE);
        FruitRawStringParser parser = new FruitRawStringParserImpl();
        var readerService = parser.parsedFruitData(fileString);
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
        saver.saveToFile(report, SAVE_TO_FILE);
        System.out.println("Data succesfully saved fo file" + SAVE_TO_FILE);
    }
}
