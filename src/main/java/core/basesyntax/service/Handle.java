package core.basesyntax.service;

import core.basesyntax.products.Fruit;
import core.basesyntax.products.FruitDto;
import java.util.HashMap;
import java.util.List;

public class Handle {
    private static final HashMap<String, ServiceAble> handleCheck = new HashMap<>();

    static {
        handleCheck.put("s", new SupplyService());
        handleCheck.put("b", new BuyService());
        handleCheck.put("r", new ReturnService());
    }

    public boolean operationWithProduct(List<FruitDto> fruitDtoList) {
        for (FruitDto dto : fruitDtoList) {
            Fruit fruit = new Fruit();
            fruit.setName(dto.getName());
            fruit.setAmount(1);
            fruit.setExpirationDate(dto.getExpiredDate());
            for (int i = 0; i < dto.getAmount(); i++) {
                handleCheck.get(dto.getOperation()).operationWithProduct(fruit);
            }
        }
        return true;
    }
}
