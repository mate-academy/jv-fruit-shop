package core;

import core.operationstrategy.OperationStrategyImpl;
import core.service.FruitStore;
import core.service.OperationData;
import core.service.OperationType;
import core.service.ReadServiceImpl;
import core.service.SplitDataImpl;
import core.service.WriteReportServiceImpl;
import core.transactions.BalanceOperationHandler;
import core.transactions.OperationHandler;
import core.transactions.PurchaseOperationHandler;
import core.transactions.ReturnOperationHandler;
import core.transactions.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String PathFrom = "src/main/dataBase.csv";
    private static final String pathTo = "firstReport";
    private static Map<OperationType, OperationHandler> strategyMap = new HashMap<>();

    public static void main(String[] args) {
        fillMap();
        ReadServiceImpl readService = new ReadServiceImpl();
        String readFromFile = readService.read(PathFrom);

        SplitDataImpl splitData = new SplitDataImpl();
        List<OperationData> splitedData = splitData.splitData(readFromFile);

        OperationStrategyImpl strategy = new OperationStrategyImpl(strategyMap);
        FruitStore fruitStore = new FruitStore(strategy);
        List<OperationData> processOperations = fruitStore.processOperations(splitedData);
        String report = fruitStore.convertListToString(processOperations);

        WriteReportServiceImpl reportService = new WriteReportServiceImpl();
        reportService.createReport(pathTo, report);
    }

    private static void fillMap() {
        strategyMap.put(OperationType.B,new BalanceOperationHandler());
        strategyMap.put(OperationType.P,new PurchaseOperationHandler());
        strategyMap.put(OperationType.S,new SupplyOperationHandler());
        strategyMap.put(OperationType.R,new ReturnOperationHandler());
    }
}
