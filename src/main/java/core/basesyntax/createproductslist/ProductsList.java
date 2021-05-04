package core.basesyntax.createproductslist;

import core.basesyntax.operationswithfile.Operation;
import java.util.List;
import java.util.Map;

public interface ProductsList {
    Map getProductList(List<Operation> operationList);
}
