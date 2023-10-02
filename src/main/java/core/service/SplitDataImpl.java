package core.service;

import core.service.impl.SplitDataService;
import java.util.ArrayList;
import java.util.List;

public class SplitDataImpl implements SplitDataService<OperationData> {
    private static final String COMMA = ",";
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int PRODUCT_INDEX = 1;
    private static final int PRODUCT_QUANTITY_INDEX = 2;

    @Override
    public List<OperationData> splitData(String data) {
        List<OperationData> result = new ArrayList<>();
        String[] lines = data.split("\n");

        for (String line : lines) {
            String[] parts = line.split(COMMA);
            if (parts.length != 3) {
                continue;
            }
            try {
                int quantity = Integer.parseInt(parts[PRODUCT_QUANTITY_INDEX].trim());
                String operationTypeStr = parts[OPERATION_TYPE_INDEX].toUpperCase();
                OperationType operationType = OperationType.valueOf(operationTypeStr);
                result.add(new OperationData(operationType, parts[PRODUCT_INDEX], quantity));
            } catch (NumberFormatException e) {
                System.err.println("Invalid quantity value: " + parts[PRODUCT_QUANTITY_INDEX]);
            } catch (IllegalArgumentException e) {
                System.err.println("Unknown operation type: " + parts[OPERATION_TYPE_INDEX]);
            }
        }

        return result;
    }
}
