package service;

import java.util.List;
import model.FruitTransaction;

public interface ConvertToFruitTransactionService {
    List<FruitTransaction> convert(List<String> rawData);
}
