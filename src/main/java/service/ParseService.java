package service;

import model.FruitTransaction;
import java.util.List;

public interface ParseService {
    List<FruitTransaction> getInfo(List<String> list);
}
