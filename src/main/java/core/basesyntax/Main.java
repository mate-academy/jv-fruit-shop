package core.basesyntax;

import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.interfaces.FileReader;
import core.basesyntax.service.interfaces.FileWriter;
import core.basesyntax.service.interfaces.TransactionParser;
import core.basesyntax.service.interfaces.FruitReportCreate;
import core.basesyntax.service.serviceimpl.FileReaderImpl;
import core.basesyntax.service.serviceimpl.FileWriterImpl;
import core.basesyntax.service.serviceimpl.FruitTransactionParser;
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

    private static StorageDaoImpl storageDao = new StorageDaoImpl();

    public static void main(String[] args) {
        List<String> fileString = readFile(OPEN_FROM_FILE);
        var readerService = parse(fileString);
        FruitStrategy strategy = initializeStrategy();

        readerService.forEach(dto -> strategy.getHandlers(dto).forEach(oh -> oh.handle(dto)));

        var report = prepareReport();
        System.out.println(report);

        writeDataToFile(report);
        System.out.println("Data successfully saved to file " + SAVE_TO_FILE);
    }

    private static List<String> readFile(String filePath) {
        FileReader reader = new FileReaderImpl();
        return reader.readFile(filePath);
    }

    private static List<FruitTransactionDto> parse(List<String> fileData) {
        TransactionParser parser = new FruitTransactionParser();
        return parser.parse(fileData);
    }

    private static FruitStrategy initializeStrategy() {
        var balance = new BalanceOperation(storageDao);
        var supply = new SupplyOperation(storageDao);
        var returns = new ReturnOperation(storageDao);
        var purchase = new PurchaseOperation(storageDao);
        List<OperationHandler> handlers = List.of(balance, returns, purchase, supply);
        return new FruitStrategy(handlers);
    }

    private static String prepareReport() {
        FruitReportCreate reportCreator = new FruitReportCreateImpl(storageDao);
        return reportCreator.createReport();
    }

    private static void writeDataToFile(String data) {
        FileWriter saver = new FileWriterImpl();
        saver.writeDataToFile(data, SAVE_TO_FILE);
    }
}
