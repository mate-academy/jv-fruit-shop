package core.basesyntax.services;

import core.basesyntax.model.FruitRecordDto;
import java.util.ArrayList;
import java.util.List;

public class Mapper {
    private static final int TYPE = 0;
    private static final int NAME = 1;
    private static final int QUANTITY = 2;
    private static final String SEPARATOR = ",";
    private Validator validator = new ValidatorImpl();

    public List<FruitRecordDto> apply(List<String> list) {
        List<FruitRecordDto> data = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            String[] rows = list.get(i).split(SEPARATOR);
            validator.validate(rows);
            FruitRecordDto dto = new FruitRecordDto(OperationType.fromString(rows[TYPE]),
                        rows[NAME], Integer.parseInt(rows[QUANTITY]));
            data.add(dto);
        }
        return data;
    }
}
