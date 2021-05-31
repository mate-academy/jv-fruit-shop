package core.basesyntax;

import java.util.List;

public class CreateReportForTypeS implements TypeHandler {
    @Override
    public void createReport(FruitDto fruitDto) {
        if (fruitDto.getType().equals("s")) {
            Storage.fruits.put(fruitDto.getFruit(), Storage.fruits.get(fruitDto.getFruit())
                    + fruitDto.getQuantity());
        }
    }
}
