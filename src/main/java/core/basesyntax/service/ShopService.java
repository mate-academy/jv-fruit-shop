package core.basesyntax.service;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.shop.Shop;
import java.util.List;

public class ShopService {
    private Shop shop;
    private FruitMapper fruitParser;

    public ShopService(Shop shop, FruitMapper fruitParser) {
        this.shop = shop;
        this.fruitParser = fruitParser;
    }

    public void precessWaybill(List<FruitDto> data) {
        for (FruitDto dto : data) {
            Fruit fruit = fruitParser.parse(dto);
            shop.trade(dto.getCommand(), fruit, dto.getQuantity());
        }
    }
}
