package core.basesyntax;

import java.util.List;

public class CreateReportForTypeR implements TypeHandler {
    @Override
    public void createReport(FruitDto fruitDto) {
        if (fruitDto.getType().equals("r")) {
            Storage.fruits.put(fruitDto.getFruit(), Storage.fruits.get(fruitDto.getFruit())
                    + fruitDto.getQuantity());
        }

    }
}
