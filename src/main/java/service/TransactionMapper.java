package service;

import java.util.List;
import model.Transaction;

public interface TransactionMapper {
    List<Transaction> map(List<String> records);
}
