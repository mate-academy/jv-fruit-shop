package service;

import java.util.List;
import model.FruitTransaction;

public interface ReaderService {

    List<FruitTransaction> readFromFile(String file);
}
