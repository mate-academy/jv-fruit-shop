package service;

import dao.ProductAccountDaoImpl;
import java.util.Arrays;
import model.ProductAccount;

public class ShopServiceImpl implements ShopService {
    private ProductAccountDaoImpl dao;
    private OperationHandlerStrategy amountStrategy;

    public ShopServiceImpl(ProductAccountDaoImpl dao, OperationHandlerStrategy amountStrategy) {
        this.dao = dao;
        this.amountStrategy = amountStrategy;
    }

    @Override
    public boolean productTransaction(String productname,
            Double productAmount,
            String operationString) {
        ProductAccount productFromDb = dao.get(productname);
        if (productFromDb == null) {
            (new ProductAccountServiceImpl(dao)).createNewProduct(productname);
            productFromDb = dao.get(productname);
        }
        Operation operationalType = Arrays.stream(Operation.values())
                .filter(o -> operationString.toUpperCase().equals(o.getOperation().toUpperCase()))
                .findFirst()
                .get();
        if (operationalType != null) {
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
