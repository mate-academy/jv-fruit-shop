package service.impl;

import dto.FruitTransactionDto;
import java.util.ArrayList;
import java.util.List;
import service.DataParser;

public class FruitDataParser implements DataParser<FruitTransactionDto> {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_TYPE_INDEX_CSV = 0;
    private static final int NAME_INDEX_CSV = 1;
    private static final int QUANTITY_INDEX_CSV = 2;

    @Override
    public List<FruitTransactionDto> parse(List<String> rawData) {
        if (rawData.isEmpty()) {
            throw new RuntimeException("File is empty");
        }
        var dtos = new ArrayList<FruitTransactionDto>(rawData.size());
        for (int i = 1; i < rawData.size(); i++) {
            String line = rawData.get(i);
            String[] columns = line.split(SEPARATOR);
            var dto = new FruitTransactionDto(
                    columns[OPERATION_TYPE_INDEX_CSV],
                    columns[NAME_INDEX_CSV],
                    Integer.parseInt(columns[QUANTITY_INDEX_CSV]));
            dtos.add(dto);

        }
        return dtos;
    }
}
