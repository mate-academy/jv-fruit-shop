package core.basesyntax.service.implementations;

import core.basesyntax.model.Operation;
import core.basesyntax.model.ShopItem;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.CsvParser;
import java.util.ArrayList;
import java.util.List;

public class CsvToTransactionDtoParser implements CsvParser<TransactionDto> {
    @Override
    public List<TransactionDto> parse(List<String> lines) {
        List<TransactionDto> result = new ArrayList<>();
        for (String line : lines) {
            String[] parsed = line.split(",");
            validate(parsed);
            result.add(new TransactionDto(Operation.fromString(parsed[0]),
                    new ShopItem(parsed[1]), Integer.parseInt(parsed[2])));
        }
        return result;
    }

    private void validate(String[] parsed) {
        String operation = parsed[0];
        String item = parsed[1];
        int quantity = Integer.parseInt(parsed[2]);
        if (operation.length() == 0 || item.length() == 0) {
            throw new RuntimeException("Invalid line in file");
        }
        if (quantity < 0) {
            throw new RuntimeException("Negative quantity!");
        }
        Operation.fromString(operation);
    }
}
