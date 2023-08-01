package core.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitStore {

    public FruitStore() {

    }

    public List<OperationData> processOperations(List<OperationData> dataList) {
        Map<String, Integer> fruitQuantityMap = new HashMap<>();

        for (OperationData data : dataList) {
            String product = data.getProduct();
            int number = data.getQuantity();
            int currentQuantity = fruitQuantityMap.getOrDefault(product, 0);
            int newQuantity = 0;

            OperationType operationType = data.getOperationType();
            switch (operationType) {
                case B:
                case S:
                case R:
                    newQuantity = currentQuantity + number;
                    break;
                case P:
                    newQuantity = currentQuantity - number;
                    break;
                default:
                    break;
            }

            fruitQuantityMap.put(product, newQuantity);
        }

        List<OperationData> result = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : fruitQuantityMap.entrySet()) {
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
