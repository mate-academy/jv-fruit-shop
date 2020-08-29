package core.basesyntax.operations;

import core.basesyntax.FruitStorage;
import core.basesyntax.model.FruitDto;

public class PurchaseOperation implements StorageOperation {
    @Override
    public void doStorageOperation(FruitDto fruitDto) {
        if (!FruitStorage.fruitStorage.containsKey(fruitDto.getFruit())) {
            throw new RuntimeException("No such fruits in storage, check input file");
        }
        if (FruitStorage.fruitStorage.get(fruitDto.getFruit()) < fruitDto.getQuantity()) {
            throw new RuntimeException("Not enough fruits to sell");
        }
        if (FruitStorage.expiration.get(fruitDto.getFruit()).isBefore(fruitDto.getExpDate())) {
            throw new RuntimeException("You sold expired fruits, check input file");
        }
        fruitDto.setQuantity(- fruitDto.getQuantity());
        FruitStorage.fruitStorage.merge(fruitDto.getFruit(),
                fruitDto.getQuantity(),
                Integer::sum);
    }
}
