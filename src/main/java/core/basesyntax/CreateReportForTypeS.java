package core.basesyntax;

import java.util.List;

public class CreateReportForTypeS implements TypeHandler {
    @Override
    public void createReport(List<FruitDto> fruitDtoList) {
        fruitDtoList.stream()
                .filter(fruitDto -> fruitDto.getType().equals("s"))
                .filter(fruitDto -> fruitDto.getFruit().equals("banana")
                        || fruitDto.getFruit().equals("apple"))
                .forEach(fruitDto -> Storage.fruits.put(fruitDto.getFruit(),
                        Storage.fruits.get(fruitDto.getFruit())
                        + Integer.parseInt(fruitDto.getQuantity())));
    }
}
