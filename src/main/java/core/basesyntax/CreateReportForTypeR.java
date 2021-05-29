package core.basesyntax;

import java.util.List;

public class CreateReportForTypeR implements TypeHandler {
    @Override
    public void createReport(List<FruitDto> fruitDtoList) {
        fruitDtoList.stream()
                .filter(fruitDto -> fruitDto.getType().equals("r"))
                .filter(fruitDto -> fruitDto.getFruit().equals("banana")
                        || fruitDto.getFruit().equals("apple"))
                .forEach(fruitDto -> Storage.fruits.put(fruitDto.getFruit(),
                        Storage.fruits.get(fruitDto.getFruit())
                        + Integer.parseInt(fruitDto.getQuantity())));
    }
}
