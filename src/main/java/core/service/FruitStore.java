package core.service;

import core.dao.StorageDaoImpl;
import core.transactions.BalanceOperationHandler;
import core.transactions.OperationHandler;
import core.transactions.PurchaseOperationHandler;
import core.transactions.ReturnOperationHandler;
import core.transactions.SupplyOperationHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitStore {
    private Map<OperationType, OperationHandler> operationHandlers;

    public FruitStore() {
        operationHandlers = new HashMap<>();
        operationHandlers.put(OperationType.B, new BalanceOperationHandler());
        operationHandlers.put(OperationType.S, new SupplyOperationHandler());
        operationHandlers.put(OperationType.R, new ReturnOperationHandler());
        operationHandlers.put(OperationType.P, new PurchaseOperationHandler());
    }

    public List<OperationData> processOperations(List<OperationData> dataList) {
        StorageDaoImpl storageDao = new StorageDaoImpl();
        Map<String, Integer> allData = storageDao.getAll();

        for (OperationData data : dataList) {
            String product = data.getProduct();
            int number = data.getQuantity();
            int currentQuantity = allData.getOrDefault(product, 0);

            OperationType operationType = data.getOperationType();
            OperationHandler handler = operationHandlers.get(operationType);

            if (handler != null) {
                int newQuantity = handler.getTransaction(currentQuantity, number);
                allData.put(product, newQuantity);
            }
        }

        List<OperationData> result = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : allData.entrySet()) {
            String product = entry.getKey();
            int number = entry.getValue();
            result.add(new OperationData(OperationType.B, product, number));
        }
        return result;
    }

    public String convertListToString(List<OperationData> dataList) {
        StringBuilder sb = new StringBuilder();

        for (OperationData data : dataList) {
            sb.append(data.getProduct())
                    .append(",")
                    .append(data.getQuantity())
                    .append("\n");
        }

        return sb.toString();
    }
}
