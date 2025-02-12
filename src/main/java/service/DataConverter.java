package service;

import java.util.List;
import model.FruitTransaction;

public interface DataConverter {
    public List<FruitTransaction> convertToTransaction(List<String> reportLines);
}
