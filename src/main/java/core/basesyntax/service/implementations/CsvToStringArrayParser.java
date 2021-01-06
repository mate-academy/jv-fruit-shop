package core.basesyntax.service.implementations;

import core.basesyntax.model.Operation;
import core.basesyntax.model.ShopItem;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.CsvParser;
import core.basesyntax.service.Validator;
import java.util.ArrayList;
import java.util.List;

public class CsvToStringArrayParser implements CsvParser<TransactionDto> {
    private static final String HEADER = "type,fruit,quantity";

    @Override
    public List<TransactionDto> parse(List<String> lines) {
        List<TransactionDto> result = new ArrayList<>();
        for (String line : lines) {
            if (line.contains(HEADER)) {
                continue;
            }
            String[] parsed = line.split(",");
            Validator.validate(parsed);
            result.add(new TransactionDto(Operation.fromString(parsed[0]),
                    new ShopItem(parsed[1]), Integer.parseInt(parsed[2])));
        }
        return result;
    }
}
