package core.fruitshop.service.CalculateHandler;

import core.fruitshop.db.Storage;
import core.fruitshop.model.Fruit;

public interface Calculatehandler {
    public void addQuantity(Fruit fruit, int quantity);
    public void subtractQuantity(Fruit fruit, int quantity);
}
