package dao;

import java.util.List;
import model.FruitTransaction;

public interface FruitParser {
    List<FruitTransaction> parse(String[] activity);
}
