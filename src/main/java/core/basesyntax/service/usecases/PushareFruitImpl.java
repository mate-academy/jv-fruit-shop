package core.basesyntax.service.usecases;

import core.basesyntax.infratructure.persistence.FruitRepository;
import core.basesyntax.service.Operation;
import java.io.IOException;

public class PushareFruitImpl extends FruitUseReposetory implements PushareFruit {

    public PushareFruitImpl(FruitRepository fruitRepository) {
        super(fruitRepository);
    }

    @Override
    public void run(String fruitName, int amount) {
        if (amount > super.getFruitRepository().getFruit(fruitName).getAmount()) {
            throw new RuntimeException("As much product is not available");
        }
        super.getFruitRepository().getFruit(fruitName)
                .setAmount(super.getFruitRepository().getFruit(fruitName)
                        .getAmount() - amount);
        try {
            super.getInsertListDao().writeInfo(Operation.PURCHASE, fruitName, amount);
        } catch (IOException e) {
            throw new RuntimeException("Can't insert to file");
        }
    }
}
