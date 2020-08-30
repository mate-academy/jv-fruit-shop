package core.basesyntax.service;

import core.basesyntax.products.Fruit;
import core.basesyntax.products.FruitDto;
import java.util.HashMap;
import java.util.List;

public class OperationHandler {
    private static final HashMap<String, Servicing> handleCheck = new HashMap<>();

    static {
        handleCheck.put("s", new SupplyService());
        handleCheck.put("b", new BuyService());
        handleCheck.put("r", new ReturnService());
    }

    public boolean handlingProduct(List<FruitDto> fruitDtoList) {
        for (FruitDto dto : fruitDtoList) {
            if (handleCheck.containsKey(dto.getOperation()) == false) {
                throw new IllegalArgumentException("Not correct operation " + dto.getOperation());
            }
            Fruit fruit = new Fruit();
            fruit.setName(dto.getName());
            fruit.setAmount(dto.getAmount());
            fruit.setExpirationDate(dto.getExpiredDate());
            handleCheck.get(dto.getOperation()).serviceProduct(fruit);
        }
        return true;
    }
}
