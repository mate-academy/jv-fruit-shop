package service.impl;

import dto.FruitTransactionDto;
import java.util.ArrayList;
import java.util.List;
import service.DataParser;

public class FruitDataParser implements DataParser<FruitTransactionDto> {
    public List<FruitTransactionDto> parse(List<String> rawData) {
        List<FruitTransactionDto> dtos = new ArrayList<>(rawData.size() - 1);
        for (int i = 1; i < rawData.size(); i++) {
            String line = rawData.get(i);
            String[] columns = line.split(",");
            var dto = new FruitTransactionDto(columns[0], columns[1], Integer.parseInt(columns[2]));
            dtos.add(dto);
        }
        return dtos;
    }
}
