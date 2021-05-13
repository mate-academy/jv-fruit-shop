package core.basesyntax.createproductslist;

import core.basesyntax.operationswithfile.Transaction;
import java.util.List;
import java.util.Map;

public interface ProductsList {
    Map getProductList(List<Transaction> transactionList);
}
