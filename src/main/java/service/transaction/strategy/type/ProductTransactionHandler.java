package service.transaction.strategy.type;

import dao.DbDao;

public abstract class ProductTransactionHandler implements TransactionHandler {
    protected DbDao dbDao;

    public ProductTransactionHandler(DbDao dbDao) {
        this.dbDao = dbDao;
    }
}
