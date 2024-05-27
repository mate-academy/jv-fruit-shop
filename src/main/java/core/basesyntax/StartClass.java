package core.basesyntax;

import core.basesyntax.service.FruitShop;
import core.basesyntax.service.impl.FruitShopImpl;

/**
 * Feel free to remove this class and create your own.
 */
public class StartClass {
    // HINT: In the `public static void main(String[] args)`
    // it is better to create instances of your classes,
    // and call their methods, but do not write any business logic in the `main` method!
    private static final String fromFileName = "database.csv";
    private static final String toFileName = "finaldatabase.csv";

    public static void main(String[] args) {
        FruitShop fruitShop = new FruitShopImpl();
        fruitShop.calculateFruitAmount(fromFileName,toFileName);
    }
}
