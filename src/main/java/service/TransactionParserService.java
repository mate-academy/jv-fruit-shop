package service;

import java.util.List;
import model.FruitTransaction;

public interface TransactionParserService {
    List<FruitTransaction> parse(String dataFromCsv);
}
