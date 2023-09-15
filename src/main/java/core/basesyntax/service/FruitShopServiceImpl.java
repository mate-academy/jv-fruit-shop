package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoCsvImpl;
import core.basesyntax.db.Storage;

public class FruitShopServiceImpl implements FruitShopService {
    private String report = "";
    private FruitDao fruitDaoCsv = new FruitDaoCsvImpl();
    private CalculateBalance calculateBalance = new CalculateBalanseImpl();

    @Override
    public void makeReport() {

        calculateBalance.calculateBalance(fruitDaoCsv.readFromFileToArray());

        for (String element: Storage.result.keySet()) {
            report += (element + ", " + Storage.result.get(element) + "\n");
        }

        fruitDaoCsv.writeToFile(report);

    }
}
