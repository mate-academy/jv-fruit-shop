package core.basesyntax.service.implementations;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.InfoRecord;
import core.basesyntax.storage.Storage;

import java.util.NoSuchElementException;

public class InfoRecordImpl implements InfoRecord {

    @Override
    public void record(FruitTransaction info) {
        if (info.getOperation().equals(FruitTransaction.Operation.BALANCE)) {
            Storage.storage.put(info.getFruit(), info.getQuantity());
        } else if (info.getOperation().equals(FruitTransaction.Operation.SUPPLY)) {
            if (Storage.storage.containsKey(info.getFruit())) {
                Integer amount = Storage.storage.get(info.getFruit());
                Storage.storage.put(info.getFruit(), amount + info.getQuantity());
            } else {
                Storage.storage.put(info.getFruit(), info.getQuantity());
            }
        } else if (info.getOperation().equals(FruitTransaction.Operation.PURCHASE)) {
            Integer amount = Storage.storage.get(info.getFruit());
            Storage.storage.put(info.getFruit(), amount - info.getQuantity());
        } else if (info.getOperation().equals(FruitTransaction.Operation.RETURN)) {
            Integer amount = Storage.storage.get(info.getFruit());
            Storage.storage.put(info.getFruit(), amount + info.getQuantity());
        } else {
            throw new NoSuchElementException("No such fruit");
        }
    }
}
