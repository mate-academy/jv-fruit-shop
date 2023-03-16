package service;

import java.util.List;
import model.FruitTransaction;

public interface FruitTransactionParserService {
    List<FruitTransaction> parse(List<String> dataFromFile);
}
