package db;

import java.util.List;
import model.FruitTransaction;

public interface Parser {
    public List<FruitTransaction> parse(List<String> data);
}
