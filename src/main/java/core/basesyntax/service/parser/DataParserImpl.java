package core.basesyntax.service.parser;

import core.basesyntax.dto.FruitTransactionDto;
import java.util.ArrayList;
import java.util.List;

public class DataParserImpl implements DataParser<FruitTransactionDto> {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_TYPE_PART_OF_STRING = 0;
    private static final int NAME_FRUIT_PART_OF_STRING = 1;
    private static final int QUANTITY_PART_OF_STRING = 2;

    @Override
    public List<FruitTransactionDto> parse(List<String> rawData) {
        if (rawData.isEmpty()) {
            throw new RuntimeException("File is empty");
        }
        var dtos = new ArrayList<FruitTransactionDto>(rawData.size() - 1);
        for (int i = 1; i < rawData.size(); i++) {
            String line = rawData.get(i);
            String[] colums = line.split(SEPARATOR);
            var dto = new FruitTransactionDto(
                    colums[OPERATION_TYPE_PART_OF_STRING],
                    colums[NAME_FRUIT_PART_OF_STRING],
                    Integer.parseInt(colums[QUANTITY_PART_OF_STRING]));
            dtos.add(dto);

        }
        return dtos;
    }
}
