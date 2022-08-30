package homework.service;

import homework.service.impl.FruitTransaction;
import java.util.List;

public interface ParseTransactionsService {
    List<FruitTransaction> parse(List<String> strings);
}
