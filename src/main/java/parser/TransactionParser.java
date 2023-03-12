package parser;

import fruittransaction.FruitTransaction;
import java.util.List;

public interface TransactionParser {
    List<FruitTransaction> parse(List<String> lines);
}
