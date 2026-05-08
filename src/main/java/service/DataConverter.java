package service;

import model.FruitTransaction;
import java.util.List;

public interface DataConverter {
    List<FruitTransaction> convert(List<String> lines);
}
