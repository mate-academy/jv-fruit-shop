package service;

import java.util.Optional;
import model.FruitRecordDto;

public class Validator {
    public static FruitRecordDto.Activities checkType(String type) {
        return Optional.ofNullable(FruitRecordDto.Activities.valueOfLabel(type))
                .orElseThrow(() -> new NullPointerException("This type of "
                        + "operation does not exist: " + type));
    }

    public static String checkFruitName(String fruitName) {
        if (fruitName.isEmpty()) {
            throw new RuntimeException("Fruit name is NOT listed");
        }
        return fruitName;
    }

    public static int checkAmount(int amount) {
        if (amount < 0) {
            throw new RuntimeException("Value cannot be negative. Your value is " + amount);
        }
        return amount;
    }
}
