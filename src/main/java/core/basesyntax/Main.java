package core.basesyntax;

import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.interfaces.FruitFileReader;
import core.basesyntax.service.interfaces.FruitFileSaver;
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
    private static final String SAVE_TO_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        List<String> fileString = readFile(OPEN_FROM_FILE);
        var readerService = parseFruitData(fileString);
        FruitStrategy strategy = initializeStrategy();

        readerService.forEach(dto -> strategy.getHandlers(dto).forEach(oh -> oh.apply(dto)));

        var report = prepareReport();
        System.out.println(report);

        saveToFile(report);
        System.out.println("Data successfully saved to file " + SAVE_TO_FILE);
    }

    private static List<String> readFile(String filePath) {
        FruitFileReader reader = new FruitFileReaderImpl();
        return reader.readFile(filePath);
    }

    private static List<FruitTransactionDto> parseFruitData(List<String> fileData) {
        FruitRawStringParser parser = new FruitRawStringParserImpl();
        return parser.parsedFruitData(fileData);
    }

    private static FruitStrategy initializeStrategy() {
        StorageDaoImpl storageDao = new StorageDaoImpl();
        var balance = new BalanceOperation(storageDao);
        var supply = new SupplyOperation(storageDao);
        var returns = new ReturnOperation(storageDao);
        var purchase = new PurchaseOperation(storageDao);
        List<OperationHandler> handlers = List.of(balance, returns, purchase, supply);
        return new FruitStrategy(handlers);
    }

    private static String prepareReport() {
        FruitReportCreate reportCreator = new FruitReportCreateImpl();
        return reportCreator.createReport(Storage.fruitsQuantity);
    }

    private static void saveToFile(String report) {
        FruitFileSaver saver = new FruitFileSaverImpl();
        saver.saveToFile(report, SAVE_TO_FILE);
    }
}
