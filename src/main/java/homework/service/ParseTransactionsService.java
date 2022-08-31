package homework.service;

import homework.model.FruitTransaction;
import java.util.List;

public interface ParseTransactionsService {
    List<FruitTransaction> parse(List<String> strings);
}
