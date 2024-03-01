package core.basesyntax;

import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.activity.ActivityHandler;
import core.basesyntax.service.activity.BalanceActivityHandler;
import core.basesyntax.service.activity.PurchaseActivityHandler;
import core.basesyntax.service.activity.ReturnActivityHandler;
import core.basesyntax.service.activity.SupplyActivityHandler;
import core.basesyntax.strategy.ActivityStrategyImpl;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, ActivityHandler> activityHandlerMap = new HashMap<>();
        activityHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceActivityHandler());
        activityHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseActivityHandler());
        activityHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnActivityHandler());
        activityHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyActivityHandler());
        ReportService reportService = new ReportService(
                new ActivityStrategyImpl(activityHandlerMap), new FruitDaoImpl());
        FileService fileService = new FileService();
        reportService.executeOperations(FileService
                .convertToTransactionsList(fileService.readFromFile()));
        fileService.writeReport(reportService.generateReport());
    }
}
