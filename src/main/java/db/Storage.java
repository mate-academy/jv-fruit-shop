package db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;

public class Storage {
    public static final List<FruitTransaction> transactions = new ArrayList<>();
    public static final Map<String, Integer> balanceStatistic = new HashMap<>();
}
