package dto;

import exception.FruitShopException;
import java.util.Arrays;

public enum Activities {
    BALANCE('b'),
    SUPPLY('s'),
    PURCHASE('p'),
    RETURN('r');

    private Character action;

    Activities(Character action) {
        this.action = action;
    }

    public static Activities of(Character action) {
        return checkAction(action);
    }

    private static Activities checkAction(char currentAction) {
        return Arrays.stream(Activities.values())
                .filter(c -> c.getAction().equals(currentAction))
                .findFirst()
                .orElseThrow(() -> new FruitShopException("Wrong symbol of action"));
    }

    private Character getAction() {
        return action;
    }
}
