package strategy;

import db.Storage;
import dto.Transaction;
import service.Validator;
import service.ValidatorImpl;

public class PurchaseOperation implements Operation {
    @Override
    public int apply(Transaction transaction) {
        Validator validator = new ValidatorImpl();
        int oldQuantity = Storage.data.get(transaction.getFruit());
        int newQuantity = oldQuantity - transaction.getQuantity();
        if (validator.checkOperation(newQuantity)) {
            Storage.data.put(transaction.getFruit(), newQuantity);
        }
        return newQuantity;
    }

}
