package core.basesyntax;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FruitStoreService fruitStoreService = new FruitStoreService();
        fruitStoreService.terminal("src/main/java/core/basesyntax/from1",
                "src/main/java/core/basesyntax/to1");
    }
}
