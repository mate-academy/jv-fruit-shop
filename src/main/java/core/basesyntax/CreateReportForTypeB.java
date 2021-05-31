package core.basesyntax;

public class CreateReportForTypeB implements TypeHandler {

    @Override
    public void createReport(FruitDto fruitDto) {
        if (fruitDto.getType().equals("b")) {
            Storage.fruits.put(fruitDto.getFruit(), fruitDto.getQuantity());
        }
    }
}
