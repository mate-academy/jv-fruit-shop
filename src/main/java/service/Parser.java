package service;

import java.util.List;
import service.impl.FruitTransaction;

public interface Parser {
    List<FruitTransaction> parse(List<String> rawData);
}
