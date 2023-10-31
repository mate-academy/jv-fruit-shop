package service;

import java.util.List;
import model.FruitTransaction;

public interface FruitPacker {
    List<FruitTransaction> makeList(List<String> transactionListString);
}

