package core.basesyntax.service.parser;

import core.basesyntax.dto.FruitTransactionDto;
import java.util.ArrayList;
import java.util.List;

public class DataParserImpl implements DataParser<FruitTransactionDto> {
    @Override
    public List<FruitTransactionDto> pars(List<String> rawData) {
        var dtos = new ArrayList<FruitTransactionDto>(rawData.size() - 1);
        for (int i = 1; i < rawData.size(); i++) {
            String line = rawData.get(i);
            String[] colums = line.split(",");
            var dto = new FruitTransactionDto(colums[0],colums[1],Integer.parseInt(colums[2]));
            dtos.add(dto);

        }
        return dtos;
    }
}
