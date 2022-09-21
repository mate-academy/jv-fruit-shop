package service.fruittransactionparser;

import java.util.List;
import model.FruitTransaction;

public interface FruitTransactionParser {
    List<FruitTransaction> parseToFruitTransactions(List<String> rowFruitTransaction);
}
