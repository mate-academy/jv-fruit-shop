package service;

import java.util.List;
import model.FruitTransaction;

public interface ParseService {
    List<FruitTransaction> parseFruitTransaction(List<String> records);
}
