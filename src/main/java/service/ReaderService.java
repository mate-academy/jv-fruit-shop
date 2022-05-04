package service;

import java.util.List;
import model.FruitTransaction;

public interface ReaderService {
    List<FruitTransaction> read(String path);
}
