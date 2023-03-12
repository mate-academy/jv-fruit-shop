package core.basesyntax.service.impl;

import core.basesyntax.model.FruitNegotiation;
import core.basesyntax.service.NegotiationParserService;
import java.util.ArrayList;
import java.util.List;

public class NegotiationParserServiceImpl implements NegotiationParserService {
    private static final String DELIMITER = ",";
    private static final int ARRAY_SIZE = 3;
    private static final int FIELD_TYPE = 0;
    private static final int FIELD_NAME = 1;
    private static final int FIELD_QUANTITY = 2;

    @Override
    public List<FruitNegotiation> createNegotiation(List<String> records) {
        List<FruitNegotiation> parsedRecords = new ArrayList<>();
        for (int i = 0; i < records.size(); i++) {
            var buffer = records.get(i).split(DELIMITER);
            if (buffer.length == ARRAY_SIZE && buffer[FIELD_TYPE].length() == FIELD_NAME) {
                parsedRecords.add(new FruitNegotiation(
                        FruitNegotiation.Operation.getCode(buffer[FIELD_TYPE].trim()),
                        buffer[FIELD_NAME].trim(),
                        Integer.parseInt(buffer[FIELD_QUANTITY].trim())));
            }
        }
        return parsedRecords;
    }
}
