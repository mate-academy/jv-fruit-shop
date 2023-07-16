package service;

import java.util.ArrayList;
import java.util.List;
import model.InputDataType;

public class InputDataResolver {
    public ArrayList<InputDataType> resolveData(List<String> lines) {
        ArrayList<InputDataType> result = new ArrayList<>();
        for (String entry : lines) {
            String[] data = entry.split(",");
            if (data.length < 3) {
                throw new RuntimeException("Invalid input data " + entry);
            }
            String operation = data[0];
            String fruit = data[1];
            int quantity = Integer.parseInt(data[2]);
            if (quantity < 0) {
                throw new RuntimeException("Fruit quantity is " + quantity
                        + "\n Fruit quantity must be greater or equal to zero");
            }
            result.add(new InputDataType(operation, fruit, quantity));
        }
        return result;
    }
}
