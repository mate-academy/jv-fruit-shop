package core.basesyntax.service.usecases;

import core.basesyntax.infratructure.persistence.FruitRepository;

public class SupplyFruitToBalanceImpl extends FruitUseReposetory implements SupplyFruitToBalance{
    public SupplyFruitToBalanceImpl(FruitRepository fruitRepository) {
        super(fruitRepository);
    }

    @Override
    public void run(String fruitName, int amount) {
        fruitRepository.getFruit(fruitName)
                .setAmount(fruitRepository.getFruit(fruitName)
                        .getAmount() + amount);
    }
}
