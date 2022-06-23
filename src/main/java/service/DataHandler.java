package service;

import java.util.List;
import model.FruitTransaction;

public interface DataHandler {
    List<FruitTransaction> handleData(List<String> data);
}
