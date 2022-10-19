package core.basesyntax.service;

import core.basesyntax.model.Transaction;

public interface DataSupplierService {
    Transaction.Operation getOperationByName(String operation);
}
