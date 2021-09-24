package service.handler;

import db.Storage;
import model.FruitOperation;
import service.inter.Operation;

public class BalanceHandler implements Operation {

    @Override
    public void apply(FruitOperation operation) {
        Storage.fruitsQuantity.put(operation.getFruit(), operation.getQuantity());
    }
}
