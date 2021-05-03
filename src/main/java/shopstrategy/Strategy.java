package shopstrategy;

import shopoperations.ListOfOperations;
import shopoperations.ShopBalanceOperation;

public interface Strategy {
    ShopBalanceOperation get(ListOfOperations type);
}
