package core.basesyntax;

import core.basesyntax.model.Fruit;
import core.basesyntax.services.BuyInterface;
import core.basesyntax.services.FruitParse;
import core.basesyntax.services.SupplyInterface;
import core.basesyntax.services.impl.Buy;
import core.basesyntax.services.impl.Parse;
import core.basesyntax.services.impl.SupplyAndReturn;

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

        for (List<String> row : fruitParse.readFile(path)) {
            if (row.get(0).equals("s")||row.get(0).equals("r")) {
                Fruit fruit = new Fruit(row.get(1).toString(), Integer.parseInt(row.get(2).toString()), LocalDate.parse(row.get(3).toString()));
                SupplyInterface supplyAndReturn = new SupplyAndReturn();
                supplyAndReturn.action(storage,fruit);

            }
            if(row.get(0).equals("b")){
                Fruit fruit = new Fruit(row.get(1).toString(), Integer.parseInt(row.get(2).toString()), LocalDate.parse(row.get(3).toString()));
                BuyInterface buyInterface = new Buy();
                buyInterface.action(storage,fruit);
            }
        }

        System.out.println(storage.getFruits());
    }
}
