package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.ActivityTypeStrategyImpl;
import core.basesyntax.service.impl.ConvertServiceImpl;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.CsvFileWriterServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.StoreServiceImpl;
import core.basesyntax.service.impl.service.ActivityTypeStrategy;
import core.basesyntax.service.impl.service.ConvertService;
import core.basesyntax.service.impl.service.CsvFileReaderService;
import core.basesyntax.service.impl.service.CsvFileWriterService;
import core.basesyntax.service.impl.service.ReportService;
import core.basesyntax.service.impl.service.StoreService;
import core.basesyntax.strategy.ActivityTypeHandler;
import core.basesyntax.strategy.BalanceActivityTypeHandler;
import core.basesyntax.strategy.PurchaseActivityTypeHandler;
import core.basesyntax.strategy.ReturnActivityTypeHandler;
import core.basesyntax.strategy.SupplyActivityTypeHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, ActivityTypeHandler> activityTypeServiceMap = new HashMap<>();
        activityTypeServiceMap.put("b", new BalanceActivityTypeHandler());
        activityTypeServiceMap.put("s", new SupplyActivityTypeHandler());
        activityTypeServiceMap.put("p", new PurchaseActivityTypeHandler());
        activityTypeServiceMap.put("r", new ReturnActivityTypeHandler());

        ActivityTypeStrategy activityTypeStrategy
                = new ActivityTypeStrategyImpl(activityTypeServiceMap);

        CsvFileReaderService fileReader = new CsvFileReaderServiceImpl(activityTypeStrategy);
        /** Insert file name without its extension */
        List<String> rows = fileReader.readData("validValues_ok");

        ConvertService converter = new ConvertServiceImpl(activityTypeStrategy);
        List<FruitTransaction> fruitTransactionList = converter.convertData(rows);

        StoreService storeService = new StoreServiceImpl(activityTypeStrategy);
        List<Integer> operationAmount = storeService.getOperationsAmount(fruitTransactionList);
        List<String> fruitList = storeService.getFruitList(fruitTransactionList);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.getReport(fruitList, operationAmount);

        CsvFileWriterService fileWriter = new CsvFileWriterServiceImpl();
        fileWriter.writeData(report);
    }
}
