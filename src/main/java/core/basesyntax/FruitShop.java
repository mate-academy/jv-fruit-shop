package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.data.CsvDataServiceImpl;
import core.basesyntax.service.data.CsvOperationServiceImpl;
import core.basesyntax.service.data.OperationService;
import core.basesyntax.service.file.CsvFileReader;
import core.basesyntax.service.file.CsvFileWriter;
import core.basesyntax.service.file.FileWriter;
import core.basesyntax.service.reports.ReportServiceImp;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;

public class FruitShop {
    private static final String DAILY_DATA_PATH = "src/main/resources/dailyActivities.csv";
    private static final String DAILY_TOTAL_REPORT_PATH = "src/main/resources/dailyRestTotals.csv";

    public static void main(String[] args) {
        final FruitDao fruitDao = new FruitDaoImpl();
        final HashMap<FruitTransaction.Operation, OperationHandler> operationHandlerMap
                = new HashMap<>() {{
                        put(FruitTransaction.Operation.BALANCE,
                                new BalanceOperationHandler(fruitDao));
                        put(FruitTransaction.Operation.SUPPLY,
                                new SupplyOperationHandler(fruitDao));
                        put(FruitTransaction.Operation.PURCHASE,
                                new PurchaseOperationHandler(fruitDao));
                        put(FruitTransaction.Operation.RETURN,
                                new ReturnOperationHandler(fruitDao));
                    }};

        List<String> activities = new CsvFileReader().readFile(DAILY_DATA_PATH);
        CsvDataServiceImpl dataServiceCsv = new CsvDataServiceImpl();
        List<FruitTransaction> fruitTransactions = dataServiceCsv.processData(activities);
        OperationService operationService =
                new CsvOperationServiceImpl(fruitDao, operationHandlerMap);
        operationService.processOperation(fruitTransactions);
        ReportServiceImp reportServiceImp = new ReportServiceImp(fruitDao);
        String data = reportServiceImp.create();
        FileWriter fileWriter = new CsvFileWriter();
        fileWriter.writeFile(DAILY_TOTAL_REPORT_PATH, data);
    }
}
