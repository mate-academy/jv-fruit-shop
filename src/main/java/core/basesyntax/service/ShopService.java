package core.basesyntax.service;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.shop.Shop;
import java.util.List;
import java.util.stream.Collectors;

public class ShopService {
    private Shop shop;
    private FruitParser fruitParser;
    private List<FruitDto> data;

    public ShopService(Shop shop, FruitParser fruitParser, List<FruitDto> data) {
        this.shop = shop;
        this.fruitParser = fruitParser;
        this.data = data;
    }

    public void precessWaybill() {
        List<String> commands = data.stream()
                .map(FruitDto::getCommand)
                .collect(Collectors.toList());
        List<Fruit> fruits = fruitParser.parse(data);
        List<Integer> quantities = data.stream()
                .map(FruitDto::getQuantity)
                .collect(Collectors.toList());

        for (int i = 0; i < commands.size(); i++) {
            shop.trade(commands.get(i), fruits.get(i), quantities.get(i));
        }
    }
}
