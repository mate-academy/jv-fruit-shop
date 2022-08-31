package service;

import java.util.List;
import model.FruitTransaction;

public interface ParserTransactionsService {
    List<FruitTransaction> parse(List<String> strings);
}
