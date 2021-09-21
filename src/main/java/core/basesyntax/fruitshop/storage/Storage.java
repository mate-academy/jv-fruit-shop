package core.basesyntax.fruitshop.storage;

import core.basesyntax.fruitshop.model.TransactionDto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    public static final List<TransactionDto> transactionList = new ArrayList<>();
    public static final Map<String, Integer> fruitBalance = new HashMap<>();
}
