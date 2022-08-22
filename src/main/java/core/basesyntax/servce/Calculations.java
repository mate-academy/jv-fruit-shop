package core.basesyntax.servce;

import core.basesyntax.dao.Dao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitsMovement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculations {
    private Dao dao;

    public Calculations(Dao dao) {
        this.dao = dao;
    }

    public Map<Fruit, Integer> generateReport() {
        Map<Fruit, Integer> report = new HashMap<>();

        List<Fruit> fruits = dao.getAllFruits();
        for (Fruit fruit : fruits) {
            List<FruitsMovement> fruitsMovements = dao.getTransactionsOff(fruit);
            int amount = getResultOf(fruitsMovements);
            report.put(fruit, amount);
        }

        return new HashMap<>();
    }

    private int getResultOf(List<FruitsMovement> fruitsMovements) {
        return 0;
    }
}
