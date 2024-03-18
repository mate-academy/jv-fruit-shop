package service;

import java.util.List;
import model.FruitTransaction;

public interface FruitTransactionMapper {
    List<FruitTransaction> map(List<String> dataFromFile);
}
