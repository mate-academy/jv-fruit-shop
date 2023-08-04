package core;

import core.service.FruitStore;
import core.service.OperationData;
import core.service.OperationType;
import core.service.ReadServiceImpl;
import core.service.SplitDataImpl;
import core.service.WriteReportServiceImpl;
import core.transactions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final ReadServiceImpl readService = new ReadServiceImpl();
    private static final SplitDataImpl splitDataImpl = new SplitDataImpl();
    private static final FruitStore fruitStore = new FruitStore(strategy());
    private static final WriteReportServiceImpl writeReport = new WriteReportServiceImpl();
    private static final String PathFrom = "src/main/dataBase.csv";

    public static void main(String[] args) {
        String readDataFromFile = readService.read(PathFrom);
        List<OperationData> splitData = splitDataImpl.splitData(readDataFromFile);
        List<OperationData> createReport = fruitStore.processOperations(splitData);
        String reportString = fruitStore.convertListToString(createReport);
        writeReport.createReport("firstReport",reportString);
    }

    private static Map<OperationType, OperationHandler> strategy() {
        Map<OperationType, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(OperationType.B, new BalanceOperationHandler());
        operationHandlers.put(OperationType.S, new SupplyOperationHandler());
        operationHandlers.put(OperationType.R, new ReturnOperationHandler());
        operationHandlers.put(OperationType.P, new PurchaseOperationHandler());
        return operationHandlers;
    }
}
