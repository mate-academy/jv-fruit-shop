package core.basesyntax.operations;

import core.basesyntax.ProductsDto;
import core.basesyntax.Storege;
import java.time.LocalDate;

public class BuyOperation implements FruitOperation {

    @Override
    public void fruitOperation(ProductsDto product) {
        String fruit = product.getName();
        int quantity = product.getQuantity();
        LocalDate purchaseDate = product.getDate();
        if (Storege.fruitStorage.get(fruit) < quantity) {
            throw new RuntimeException("Not enough fruits in shop");
        }
        if (Storege.expirationDateStorage.get(fruit).isBefore(purchaseDate)) {
            throw new RuntimeException("Spoiled fruit");
        }
        Storege.fruitStorage.put(fruit, Storege.fruitStorage.get(fruit) - quantity);
    }
}
