package core.basesyntax.repository;

import core.basesyntax.model.FruitTransaction;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FruitStorage {
    public static final Map<String, Integer> fruitsOnStock = new LinkedHashMap<>();
    public static final List<FruitTransaction> transactions = new ArrayList<>();

}
