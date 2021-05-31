package core.basesyntax;

public class CreateReportForTypeP implements TypeHandler {
    @Override
    public void createReport(FruitDto fruitDto) {
        if (fruitDto.getType().equals("p")) {
            if (Storage.fruits.get(fruitDto.getFruit()) >= fruitDto.getQuantity()) {
                Storage.fruits.put(fruitDto.getFruit(), Storage.fruits.get(fruitDto.getFruit())
                        - fruitDto.getQuantity());
            } else throw new RuntimeException("You can't buy this fruit!");

        }
    }
}
