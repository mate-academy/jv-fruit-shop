package service;

import java.util.List;
import model.FruitTransaction;

public interface TransactionParseService {
    List<FruitTransaction> parse(List<String> lines);
}
