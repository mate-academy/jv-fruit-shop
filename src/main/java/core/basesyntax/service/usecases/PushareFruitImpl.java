package core.basesyntax.service.usecases;

import core.basesyntax.infratructure.persistence.FruitRepository;

public class PushareFruitImpl extends FruitUseReposetory implements PushareFruit{

    public PushareFruitImpl(FruitRepository fruitRepository) {
        super(fruitRepository);
    }

    @Override
    public void run(String fruitName, int amount) {
        if (amount > fruitRepository.getFruit(fruitName).getAmount()) {
            throw new RuntimeException("As much product is not available");
        }
        fruitRepository.getFruit(fruitName)
                .setAmount(fruitRepository.getFruit(fruitName)
                        .getAmount() - amount);
    }
}
