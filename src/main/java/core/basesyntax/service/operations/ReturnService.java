package core.basesyntax.service.operations;

import core.basesyntax.model.FruitTransaction;

public class ReturnService implements Operations{
    /**
     * return some amount of fruis back to storage
     */
    @Override
    public void realization(FruitTransaction fruitTransaction){
        SupplyService supplyService = new SupplyService();
        supplyService.realization(fruitTransaction);
    }




}
