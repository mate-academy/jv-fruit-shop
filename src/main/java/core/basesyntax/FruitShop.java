package core.basesyntax;

import core.basesyntax.services.FruitParse;
import core.basesyntax.services.impl.Parse;

public class FruitShop {
    private String path;

    public FruitShop(String path) {
        this.path = path;
    }

    public void start(){
        Storage  storage = new Storage();
        FruitParse fruitParse = new Parse();


        System.out.println(fruitParse.readFile(path));
    }
}
