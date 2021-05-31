package core.basesyntax;

public class SupplyOperation implements TypeHandler {
    @Override
    public void handle(FruitDto fruitDto) {
        Storage.fruits.put(fruitDto.getFruit(), Storage.fruits.get(fruitDto.getFruit())
                    + fruitDto.getQuantity());
    }
}
