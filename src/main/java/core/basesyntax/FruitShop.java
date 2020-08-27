package core.basesyntax;

import core.basesyntax.model.Fruit;
import core.basesyntax.services.*;
import core.basesyntax.services.impl.Parse;

import java.time.LocalDate;
import java.util.List;

public class FruitShop {
    private final String path;

    public FruitShop(String path) {
        this.path = path;
    }

    public void start() {
        Storage storage = new Storage();
        FruitParse fruitParse = new Parse();

        for (List<String> row : fruitParse.readFile(path)) {
            ActionInterface action = new ShopInterfaceStrategy().get(row.get(0));
           if(action!=null){
               Fruit fruit = new Fruit(row.get(1), Integer.parseInt(row.get(2)), LocalDate.parse(row.get(3)));
               action.action(storage,fruit);
           }
        }
        System.out.println(storage.getFruits());
    }
}
