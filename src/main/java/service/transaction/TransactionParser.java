package service.transaction;

import java.util.List;
import model.Transaction;

public interface TransactionParser {
    List<Transaction> parse(List<String> data);
}
