package service;

import java.util.List;
import models.FruitTransaction;

public interface Parser {
    List<FruitTransaction> parse(List<String> dataFromFile);
}
