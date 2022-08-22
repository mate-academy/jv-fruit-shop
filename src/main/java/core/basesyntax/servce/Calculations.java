package core.basesyntax.servce;

import core.basesyntax.dao.Dao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitMovement;
import core.basesyntax.model.MovementType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculations {
    private final Dao dao;

    public Calculations(Dao dao) {
        this.dao = dao;
    }

    public Map<Fruit, Integer> generateReport() {
        Map<Fruit, Integer> report = new HashMap<>();
        List<Fruit> fruits = dao.getAllFruits();
        for (Fruit fruit : fruits) {
            List<FruitMovement> fruitsMovements = dao.getTransactionsOff(fruit);
            int amount = getResultOf(fruitsMovements);
            report.put(fruit, amount);
        }
        return report;
    }

    private int getResultOf(List<FruitMovement> fruitMovements) {
        int balance = getAmount(MovementType.BALANCE, fruitMovements);
        int supplied = getAmount(MovementType.SUPPLY, fruitMovements);
        int purchased = getAmount(MovementType.PURCHASE, fruitMovements);
        int returned = getAmount(MovementType.RETURN, fruitMovements);
        return balance + supplied - purchased + returned;
    }

    private int getAmount(MovementType type, List<FruitMovement> fruitMovements) {
        return fruitMovements.stream()
                .filter(fruitMovement -> fruitMovement.getType().equals(type))
                .mapToInt(FruitMovement::getAmount)
                .sum();
    }

}
