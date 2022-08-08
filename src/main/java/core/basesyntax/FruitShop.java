package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.data.DataServiceCsv;
import core.basesyntax.service.file.FileReaderCsv;
import core.basesyntax.service.file.FileWriter;
import core.basesyntax.service.file.FileWriterCsv;
import core.basesyntax.service.reports.DailyTotals;
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

        List<String> activities = new FileReaderCsv().readFile(DAILY_DATA_PATH);
        DataServiceCsv dataServiceCsv = new DataServiceCsv();
        dataServiceCsv.processData(activities, operationHandlerMap);
        DailyTotals dailyTotals = new DailyTotals();
        String data = dailyTotals.create();
        FileWriter fileWriter = new FileWriterCsv();
        fileWriter.writeFile(DAILY_TOTAL_REPORT_PATH, data);
    }
}
