package core.basesyntax.imp;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecordDto;
import core.basesyntax.model.Storage;
import core.basesyntax.service.FruitOperation;
import core.basesyntax.service.FruitService;
import java.util.List;
import java.util.Map;

public class FruitServiceImp implements FruitService {
    private final Map<String, FruitOperation> map;

    public FruitServiceImp(Map<String, FruitOperation> map) {
        this.map = map;
    }

    public String makeReport() {
        StringBuilder builder = new StringBuilder();
        builder.append("fruit").append(",").append("quantity")
                .append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> fruitEntry : Storage.fruits.entrySet()) {
            builder.append(fruitEntry.getKey().getName())
                    .append(",").append(fruitEntry.getValue())
                    .append(System.lineSeparator());
        }
        return String.valueOf(builder);
    }

    public void saveData(List<FruitRecordDto> listParse) {
        for (FruitRecordDto fruitRecordDto : listParse) {
            map.get(fruitRecordDto.getOperation()).operation(fruitRecordDto);
        }
    }
}
