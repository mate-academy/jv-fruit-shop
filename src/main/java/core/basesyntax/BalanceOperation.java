package core.basesyntax;

public class BalanceOperation implements TypeHandler {

    @Override
    public void handle(FruitDto fruitDto) {
        Storage.fruits.put(fruitDto.getFruit(), fruitDto.getQuantity());
    }
}
