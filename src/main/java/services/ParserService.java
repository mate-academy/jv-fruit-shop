package services;

import java.util.List;
import model.FruitTransaction;

public interface ParserService {
    List<FruitTransaction> parse(List<String> transactions);
}
