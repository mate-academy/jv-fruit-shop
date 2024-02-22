package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.service.CsvConverter;
import core.basesyntax.service.CsvFileReader;
import core.basesyntax.service.CsvWriter;
import core.basesyntax.service.Operation;
import core.basesyntax.service.ShopServiceStrategy;
import core.basesyntax.service.operation.BalanceHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseHandler;
import core.basesyntax.service.operation.ReturnHandler;
import core.basesyntax.service.operation.SupplyHandler;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class HelloWorld {
    private static final DateTimeFormatter FORMATTED = DateTimeFormatter.ofPattern(
            "yyyy-MM-dd_HH-mm-ss");
    private static final String INPUT_DATA_FILE = "src"
            + File.separator
            + "main" + File.separator
            + "resources" + File.separator
            + "TryMe.csv";
    private static final String OUTPUT_DATA_FILE = "src" + File.separator
                + "main" + File.separator
                + "resources" + File.separator
                + "report_" + LocalDateTime.now().format(FORMATTED)
            + ".csv";

    public static void main(String[] args) {
        Map<Operation, OperationHandler> opHandlerMap = new HashMap<>();
        opHandlerMap.put(Operation.BALANCE, new BalanceHandler());
        opHandlerMap.put(Operation.SUPPLY, new SupplyHandler());
        opHandlerMap.put(Operation.PURCHASE, new PurchaseHandler());
        opHandlerMap.put(Operation.RETURN, new ReturnHandler());

        CsvFileReader csvFileReader = new CsvFileReader();
        CsvConverter csvConverter = new CsvConverter();
        CsvWriter csvWriter = new CsvWriter();
        StorageDao stDao = new StorageDaoImpl();
        ShopServiceStrategy shopStrategy = new ShopServiceStrategy(opHandlerMap);

        String dataToConvert = csvFileReader.readFile(INPUT_DATA_FILE);
        var convertedToClassObj = csvConverter.convertToRecord(dataToConvert);
        shopStrategy.processDataFromObj(convertedToClassObj);
        String contentToWrite = stDao.getStorageContents();
        csvWriter.writeReportToFile(OUTPUT_DATA_FILE, contentToWrite);
    }
}
