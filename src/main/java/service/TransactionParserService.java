package service;

import java.util.List;
import model.FruitTransaction;

public interface TransactionParserService {
    List<FruitTransaction> parse(List<String> data);
}
