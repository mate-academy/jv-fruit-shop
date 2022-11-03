package myfirstproject.strategy;

import java.util.List;
import java.util.Map;
import myfirstproject.model.Fruit;

public class SeparationOfOperations {
    public void toDoEachOperation(List<String[]> list, Map<String, OperationHandler> operation) {
        for (String [] s : list) {
            if (s[0].length() == 1) {
                Fruit fruit = new Fruit(s[1]);
                int value = Integer.parseInt(s[2]);
                operation.get(s[0]).changeValue(fruit, value);
            }
        }
    }
}
