package core.basesyntax.servce;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitMovement;
import core.basesyntax.model.MovementType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Calculations {
    public Map<Fruit, Integer> generateReport(List<FruitMovement> fruitsMovements) {
        Map<Fruit, Integer> report = new HashMap<>();
        List<Fruit> fruits = fruitsMovements.stream()
                .map(FruitMovement::getFruit)
                .distinct()
                .collect(Collectors.toList());
        for (Fruit fruit : fruits) {
            List<FruitMovement> movementOf = fruitsMovements.stream()
                    .filter(f -> fruit.equals(f.getFruit()))
                    .collect(Collectors.toList());
            int amount = getResultOf(movementOf);
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
