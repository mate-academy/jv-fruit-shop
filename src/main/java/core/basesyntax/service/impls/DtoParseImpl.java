package core.basesyntax.service.impls;

import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.DtoParser;
import java.util.ArrayList;
import java.util.List;

public class DtoParseImpl implements DtoParser {
    private static final int OPERATION = 0;
    private static final int FRUIT_NAME = 1;
    private static final int QUANTITY = 2;
    private static final String CSV_SEPARATOR = ",";

    @Override
    public List<FruitRecordDto> parse(List<String> fileLines) {
        List<FruitRecordDto> fruitDto = new ArrayList<>(fileLines.size());
        String[] tmpLineRecord;

        for (String fileLine : fileLines) {
            tmpLineRecord = fileLine.split(CSV_SEPARATOR);
            fruitDto.add(new FruitRecordDto(tmpLineRecord[OPERATION].toLowerCase().trim(),
                    tmpLineRecord[FRUIT_NAME].toLowerCase().trim(),
                    Integer.valueOf(tmpLineRecord[QUANTITY])));
        }
        return fruitDto;
    }
}
