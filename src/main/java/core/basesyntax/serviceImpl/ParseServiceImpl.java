package core.basesyntax.serviceImpl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ParseService;
import java.util.ArrayList;
import java.util.List;

public class ParseServiceImpl implements ParseService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    @Override
    public List<Transaction> parseLine(List<String> lines) {
        List<Transaction> parsed_lines = new ArrayList<>();
        for (String line : lines) {
            String[] split = line.split(",");
            String operation = split[OPERATION_INDEX];
            Fruit fruit = new Fruit(split[FRUIT_INDEX]);
            int quantity = Integer.parseInt(split[QUANTITY_INDEX]);
            parsed_lines.add(new Transaction(operation, fruit, quantity));
        }
        return parsed_lines;
    }
}
