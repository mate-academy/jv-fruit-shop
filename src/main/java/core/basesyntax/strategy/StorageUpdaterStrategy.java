package core.basesyntax.strategy;

import core.basesyntax.FruitDto;

public class StorageUpdaterStrategy {

    public void apply(FruitDto fruitDto) {
        if (fruitDto.getTransaction() == null) {
            throw new RuntimeException("Invalid transaction.");
        }
        if (fruitDto.getTransaction().equals("s")) {
            FruitTransaction transaction = new SupplyTransaction();
            transaction.apply(fruitDto);
        }
        if (fruitDto.getTransaction().equals("b")) {
            FruitTransaction transaction = new BuyTransaction();
            transaction.apply(fruitDto);
        }
        if (fruitDto.getTransaction().equals("r")) {
            FruitTransaction transaction = new ReturnTransaction();
            transaction.apply(fruitDto);
        }
    }
}
