package core.basesyntax.service.impl;

import core.basesyntax.model.Balance;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Purchase;
import core.basesyntax.model.Return;
import core.basesyntax.model.Supply;
import core.basesyntax.service.Parser;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
    @Override
    public List<Operation> parseToOperations(List<String> records) {
        List<Operation> operations = new ArrayList<>();
        for (var record : records) {
            String[] splitData = record.split(",");
            if (splitData.length != 3) {
                throw new RuntimeException("Can't parse data - " + record);
            }
            switch (splitData[0]) {
                case "b" -> operations.add(new Balance(splitData[1],
                        Integer.parseInt(splitData[2])));
                case "s" -> operations.add(new Supply(splitData[1],
                        Integer.parseInt(splitData[2])));
                case "p" -> operations.add(new Purchase(splitData[1],
                        Integer.parseInt(splitData[2])));
                case "r" -> operations.add(new Return(splitData[1],
                        Integer.parseInt(splitData[2])));
                default -> throw new RuntimeException("Can't parse data - " + record);
            }
        }
        return operations;
    }
}
