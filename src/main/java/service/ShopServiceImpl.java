package service;

import dao.ProductAccountDaoImpl;
import java.util.Arrays;
import java.util.Optional;
import model.ProductAccount;

public class ShopServiceImpl implements ShopService {
    private ProductAccountDaoImpl dao;
    private OperationHandlerStrategy amountStrategy;

    public ShopServiceImpl(ProductAccountDaoImpl dao, OperationHandlerStrategy amountStrategy) {
        this.dao = dao;
        this.amountStrategy = amountStrategy;
    }

    @Override
    public boolean execProductTransaction(String productname,
                                          Double productAmount,
                                          String operationString) {
        Optional<ProductAccount> optProductAccount = dao.get(productname);
        Optional<Operation> optOperationType = Arrays.stream(Operation.values())
                .filter(o -> operationString.toUpperCase().equals(o.getOperation().toUpperCase()))
                .findFirst();

        if (optProductAccount.isPresent() && optOperationType.isPresent()) {
            ProductAccount productFromDb = optProductAccount.get();
            Operation operationalType = optOperationType.get();
            productFromDb.setAmount(productFromDb.getAmount()
                        + amountStrategy.get(operationalType)
                        .getAmount(productAmount));
            dao.update(productFromDb);
            return true;
        } else {
            return false;
        }
    }
}

