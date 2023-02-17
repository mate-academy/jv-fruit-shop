package service.transaction;

import dao.StorageDao;
import dao.StorageDaoImpl;

public interface TransactionHandler {
    StorageDao storageDao = new StorageDaoImpl();
    void apply(String fruit, Integer amount);
}
