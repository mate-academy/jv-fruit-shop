package core.basesyntax.service.impl;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.DataParser;
import java.util.ArrayList;
import java.util.List;

public class FruitDataParser implements DataParser<FruitTransactionDto> {
    private static final String DELIMITER = ",";

    @Override
    public List<FruitTransactionDto> parse(List<String> rawData) {
        List<FruitTransactionDto> fruitsList = new ArrayList<>(rawData.size());
        for (int i = 1; i < rawData.size(); i++) {
            String line = rawData.get(i);
            String[] strings = line.split(DELIMITER);
            FruitTransactionDto dto =
                    new FruitTransactionDto(strings[0], strings[1], Integer.parseInt(strings[2]));
            fruitsList.add(dto);
        }
        return fruitsList;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}

