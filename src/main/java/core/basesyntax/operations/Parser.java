package core.basesyntax.operations;

import core.basesyntax.model.Fruit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Parser {

    public List<Transaction> parse(List<String> fruitsFromFile) {
        List<Transaction> parser = new ArrayList<>();
        for (int i = 1; i < fruitsFromFile.size(); i++) {
            String[] line = fruitsFromFile.get(i).split(",");
            parser.add(new Transaction(line[0], line[1], Integer.parseInt(line[2]), line[3]));
        }
        return parser;
    }

    public Map<String, Long> parseToMap(List<Fruit> fruit) {
        List<String> stringFruit = new ArrayList<>();
        for (int i = 0; i < fruit.size(); i++) {
            stringFruit.add(fruit.get(i).getTypeOfFruit());
        }
        return stringFruit.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
