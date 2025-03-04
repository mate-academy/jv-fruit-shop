package service;

import model.FruitTransaction;
import java.util.List;

public interface DataConverter {
    List<FruitTransaction> convertToTransaction(List<String> lines);
}
