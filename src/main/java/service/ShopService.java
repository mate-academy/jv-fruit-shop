package service;

import java.util.List;
import model.Transaction;

public interface ShopService {
    void process(List<Transaction> transactionList);
}
