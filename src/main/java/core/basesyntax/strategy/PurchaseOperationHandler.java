package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler{
	@Override
	public void apply(FruitTransaction fruitTransaction) {
		Fruit fruit = fruitTransaction.getFruit();
		Integer currentQuantity = Storage.getStorage().get(fruit);
		if (currentQuantity >= fruitTransaction.getQuantity()) {
			Storage.getStorage().put(fruit, currentQuantity - fruitTransaction.getQuantity());
		}
	}
}
