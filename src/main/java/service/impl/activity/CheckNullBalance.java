package service.impl.activity;

import java.util.Map;

public class CheckNullBalance {

    public static Integer get(String fruitName, Map<String, Integer> report) {
        Integer currentAmount = report.get(fruitName);
        if (currentAmount == null) {
            throw new RuntimeException("Activity without initial balance found fot the fruit: "
                    + fruitName);
        }
        return currentAmount;
    }
}
