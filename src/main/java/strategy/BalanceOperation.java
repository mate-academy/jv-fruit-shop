package strategy;

import db.Storage;
import dto.Transaction;

public class BalanceOperation implements Operation {
    @Override
    public int apply(Transaction transaction) {
        int newQuantity = transaction.getQuantity();
        Storage.data.put(transaction.getFruit(), newQuantity);
        return newQuantity;
    }
}
