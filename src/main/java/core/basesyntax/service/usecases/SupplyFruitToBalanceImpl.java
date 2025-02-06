package core.basesyntax.service.usecases;

import core.basesyntax.infratructure.persistence.FruitRepository;
import core.basesyntax.service.Operation;
import java.io.IOException;

public class SupplyFruitToBalanceImpl extends FruitUseReposetory implements SupplyFruitToBalance {
    public SupplyFruitToBalanceImpl(FruitRepository fruitRepository) {
        super(fruitRepository);
    }

    @Override
    public void run(String fruitName, int amount) {
        super.getFruitRepository().getFruit(fruitName)
                .setAmount(super.getFruitRepository().getFruit(fruitName)
                        .getAmount() + amount);
        try {
            super.getInsertListDao().writeInfo(Operation.SUPPLY, fruitName, amount);
        } catch (IOException e) {
            throw new RuntimeException("Can't insert to file");
        }
    }
}
