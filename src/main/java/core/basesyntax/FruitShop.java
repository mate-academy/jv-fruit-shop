package core.basesyntax;

import core.basesyntax.model.Fruit;
import core.basesyntax.services.FruitParse;
import core.basesyntax.services.impl.Parse;

import java.time.LocalDate;
import java.util.List;

public class FruitShop {
    private String path;

    public FruitShop(String path) {
        this.path = path;
    }

    public void start() {
        Storage storage = new Storage();
        FruitParse fruitParse = new Parse();

        for (List row : fruitParse.readFile(path)) {
            if (row.get(0).equals("s")||row.get(0).equals("r")) {
                System.out.println(row.get(0));
                storage.getFruits().add(new Fruit(row.get(1).toString(), Integer.parseInt(row.get(2).toString()), LocalDate.parse(row.get(3).toString())));
            }


        }

        System.out.println(storage.getFruits());
    }
}
