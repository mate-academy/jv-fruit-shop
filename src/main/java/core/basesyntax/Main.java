package core.basesyntax;

import core.basesyntax.dao.InputDao;
import core.basesyntax.dao.InputDaoImpl;
import core.basesyntax.service.CsvFileReader;
import core.basesyntax.service.CsvFileReaderImpl;
import core.basesyntax.service.CsvFileWriter;
import core.basesyntax.service.CsvFileWriterImpl;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.StorageServiceImpl;
import core.basesyntax.service.activities.BalanceHandler;
import core.basesyntax.service.activities.Handler;
import core.basesyntax.service.activities.PurchaseHandler;
import core.basesyntax.service.activities.ReturnHandler;
import core.basesyntax.service.activities.SupplyHandler;
import java.util.HashMap;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) {
        Map<String, Handler> strategyMap = new HashMap<>();
        strategyMap.put("b", new BalanceHandler());
        strategyMap.put("p", new PurchaseHandler());
        strategyMap.put("r", new ReturnHandler());
        strategyMap.put("s", new SupplyHandler());

        CsvFileReader reader = new CsvFileReaderImpl("storeInputData.csv");
        InputDao inputDao = new InputDaoImpl();
        StorageService service = new StorageServiceImpl(inputDao, reader);
        service.putDataToStorage(strategyMap);
        CsvFileWriter writer = new CsvFileWriterImpl(inputDao);
        writer.createReportFile("src/main/resources/reportStoreInputData.csv");
    }
}
