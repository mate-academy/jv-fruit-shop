package service;

import java.util.ArrayList;
import model.FruitTransaction;

public interface ReadedDataParser {
    ArrayList<FruitTransaction> convertToFruitTransactionList(ArrayList<String> fileLines);
}
