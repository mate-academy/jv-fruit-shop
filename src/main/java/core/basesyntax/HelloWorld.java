package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitsService;

/**
 * Feel free to remove this class and create your own.
 */
public class HelloWorld {
    public static void main(String[] args) {
        FruitsService fruitsService = new FruitsService();
        fruitsService.addFruit();
        System.out.println(Storage.fruits);
    }
}
