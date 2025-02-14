package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProcessingImpl implements DataProcessingMet {
    @Override
    public Map<String, Integer> processData(List<String> fruits) {
        Map<String, Integer> result = new HashMap<>();

        for (int i = 0; i < fruits.size(); i++) {
            String[] fruitInArr = fruits.get(i).split(",");
            String operation = fruitInArr[0];
            String name = fruitInArr[1];
            int quantity = Integer.parseInt(fruitInArr[2]);

            int newQuantity = 0;

            if (result.size() != 0) {
                boolean found = false;
                for (Map.Entry<String, Integer> entry : result.entrySet()) {
                    if (entry.getKey().equals(name)) {
                        newQuantity = (operation.equals("p")) ? -quantity : quantity;
                        entry.setValue(entry.getValue() + newQuantity);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    newQuantity = (operation.equals("p")) ? -quantity : quantity;
                    result.put(name, newQuantity);
                }
            } else {
                newQuantity = (operation.equals("p")) ? -quantity : quantity;
                result.put(name, newQuantity);
                //break;
            }
        }
        return result;
    }
}
