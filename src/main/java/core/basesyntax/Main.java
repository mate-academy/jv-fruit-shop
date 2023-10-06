package core.basesyntax;

import dao.FruitShopDao;
import dao.impl.FruitShopDaoCsvImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.ActivitiesStrategy;
import service.ReaderFileService;
import service.ReportService;
import service.activities.ActivitiesHandler;
import service.activities.BalanceActivitiesHandler;
import service.activities.PurchaseActivitiesHandler;
import service.activities.ReturnActivitiesHandler;
import service.activities.SupplyActivitiesHandler;
import service.impl.ActivitiesStrategyImpl;
import service.impl.ReaderFileServiceImpl;
import service.impl.ReportServiceImpl;

public class Main {
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, ActivitiesHandler> activitiesHandlerMap = new HashMap<>();
        activitiesHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceActivitiesHandler());
        activitiesHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseActivitiesHandler());
        activitiesHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnActivitiesHandler());
        activitiesHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyActivitiesHandler());

        ReaderFileService readerFileService = new ReaderFileServiceImpl();
        List<String> listFromFile = readerFileService.readFromFile();

        ActivitiesStrategy activitiesStrategy = new ActivitiesStrategyImpl(activitiesHandlerMap);

        FruitShopDao fruitShopDao = new FruitShopDaoCsvImpl(activitiesStrategy, readerFileService);
        fruitShopDao.processTransactions(listFromFile);

        ReportService reportService = new ReportServiceImpl(fruitShopDao);

        reportService.createReport();
    }

}
