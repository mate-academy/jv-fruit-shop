package service;

import java.util.List;
import model.FruitTransactionModel;

// Interface for parsing the file.
public interface FileParser {
    List<FruitTransactionModel> getFruitTransaction(String activity);
}
