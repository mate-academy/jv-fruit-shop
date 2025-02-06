package core.basesyntax.service.usecases;

import core.basesyntax.infratructure.persistence.FruitRepository;

public class ReturnFruitToBalanceImpl extends FruitUseReposetory implements ReturnFruitToBalance{

    public ReturnFruitToBalanceImpl(FruitRepository fruitRepository) {
        super(fruitRepository);
    }

    @Override
    public void run(String fruitName, int amount) {
        fruitRepository.getFruit(fruitName)
                .setAmount(fruitRepository.getFruit(fruitName)
                        .getAmount() + amount);
    }


}