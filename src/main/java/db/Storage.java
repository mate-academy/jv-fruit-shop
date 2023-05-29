package db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.FruitTransaction;

public class Storage {
    public static final List<FruitTransaction> FRUIT_TRANSACTIONS = new ArrayList<>();
    public static final HashMap<String, Integer> CURRENT_BALANCE_BY_FRUIT = new HashMap<>();
}
