package core.basesyntax.operations;

import core.basesyntax.ProductsDto;
import core.basesyntax.Storege;
import java.time.LocalDate;

public class SupplyOperation implements FruitOperation {
    private static final LocalDate TODAY = LocalDate.parse("2020-08-27");

    @Override
    public void fruitOperation(ProductsDto product) {
        String fruit = product.getName();
        int quantity = product.getQuantity();
        LocalDate expirationDate = product.getDate();
        if (TODAY.isAfter(expirationDate)) {
            throw new RuntimeException("Spoiled fruit");
        }
        Storege.fruitStorage.merge(fruit, quantity, (oldVal, newVal) -> oldVal + newVal);
        Storege.expirationDateStorage.put(fruit, expirationDate);
    }
}
