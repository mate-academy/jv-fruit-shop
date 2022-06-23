package service;

import java.util.List;
import model.FruitTransaction;

public interface SplitInformation {
    List<FruitTransaction> createTransactionList(List<String> info);
}
