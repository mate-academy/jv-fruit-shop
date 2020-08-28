package core.basesyntax;

import java.util.Set;

public class FinalString {
    private StringBuilder finalString = new StringBuilder("fruit,quantity");

    public String getFinalString() {
        Set<String> keys = ProductCalculator.STORAGE.keySet();
        String[] keysArray = keys.toArray(new String[0]);
        for (String s : keysArray) {
            int totalAmount = 0;
            for (int j = 0; j < ProductCalculator.STORAGE.get(s).size(); j++) {
                totalAmount = totalAmount + ProductCalculator.STORAGE.get(s).get(j).getQuantity();
            }
            finalString.append("\n").append(s).append(",").append(totalAmount);
        }
        return finalString.toString();
    }
}
