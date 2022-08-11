package service.operation;

import service.ProductTransaction;

public interface Operation {
    void doOperation(ProductTransaction transaction);
}
