package service;

import java.util.Optional;
import model.FruitRecordDto;

public class Validator {
    public static FruitRecordDto.Activities checkType(String type) {
        return Optional.ofNullable(FruitRecordDto.Activities.valueOfLabel(type))
                .orElseThrow(() -> new NullPointerException("This type of "
                        + "operation does not exist: " + type));
    }

    public static String checkNameGoods(String nameGoods) {
        if (nameGoods.isEmpty()) {
            throw new RuntimeException("Product name is NOT listed");
        }
        return nameGoods;
    }

    public static int checkAmount(int amount) {
        if (amount < 0) {
            throw new RuntimeException("Value cannot be negative. Your value is " + amount);
        }
        return amount;
    }
}
