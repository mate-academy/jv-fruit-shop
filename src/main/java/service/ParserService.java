package service;

import java.util.List;
import models.FruitTransaction;

public interface ParserService {
    List<FruitTransaction> parse(List<String> readeData);
}
