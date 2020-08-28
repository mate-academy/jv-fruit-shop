package core.basesyntax;

import core.basesyntax.interfaces.Operation;
import java.util.List;

public class AddFruit implements Operation {

    public List<Fruit> operation(List<Fruit> fruitsAvailable, Transaction fruitsFromFile) {
        for (int i = 0; i < fruitsFromFile.getAmount(); i++) {
            fruitsAvailable.add(new Fruit(fruitsFromFile.getTypeOfFruit(),
                    fruitsFromFile.getExpirationDate()));
        }
        return fruitsAvailable;
    }
}
