package service.operation;

import dao.FruitDao;
import model.FruitTransaction;

public interface OperationHandler {
    void operation(FruitTransaction transaction, FruitDao dao);
}
