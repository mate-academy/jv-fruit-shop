package core.basesyntax.db;

import java.util.HashMap;

public class Storage {
    private static HashMap<String, Integer> balanceOfFruit = new HashMap<>();

    public static void changeBalance(String fruit, Integer balance) {
        balanceOfFruit.put(fruit,balance);
    }

    public static Integer getBalance(String fruit) {
        return balanceOfFruit.get(fruit);
    }

    public static boolean isFruitExist(String fruit) {
        return balanceOfFruit.containsKey(fruit);
    }

    public static HashMap<String, Integer> getBalanceOfFruit() {
        return balanceOfFruit;
    }

    public static void setBalanceOfFruit(HashMap<String, Integer> balanceOfFruit) {
        Storage.balanceOfFruit = balanceOfFruit;
    }
}
