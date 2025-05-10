package service;

import java.util.List;
import model.FruitTransaction;

public interface TransactionParserService {
    FruitTransaction parseFromString(String inputStrings);

    List<FruitTransaction> parseFromListStrings(List<String> dataFromFile);
}
