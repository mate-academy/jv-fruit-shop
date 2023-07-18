package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.Fruit;
import model.InputDataType;
import model.Operation;
import service.InputDataResolver;

public class InputDataResolverImpl implements InputDataResolver {
    private static final String SEPARATOR = ",";
    private static final int MIN_ELEMENT_COUNT = 3;
    private static final int MIN_QUANTITY = 0;

    @Override
    public ArrayList<InputDataType> resolveData(List<String> lines) {
        ArrayList<InputDataType> result = new ArrayList<>();
        for (String entry : lines) {
            String[] data = entry.split(SEPARATOR);
            if (data.length < MIN_ELEMENT_COUNT) {
                throw new RuntimeException("Invalid input data " + entry);
            }
            Operation operation = getOperationByCode(data[0]);
            String fruitName = data[1];
            int quantity = Integer.parseInt(data[2]);
            if (quantity < MIN_QUANTITY) {
                throw new RuntimeException("Fruit quantity is " + quantity
                        + "\n Fruit quantity must be greater or equal to zero");
            }
            result.add(new InputDataType(operation, new Fruit(fruitName, quantity)));
        }
        return result;
    }

    private Operation getOperationByCode(String code) {
        return Operation.getByCode(code);
    }
}
