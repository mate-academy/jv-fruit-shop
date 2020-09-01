package core.basesyntax.operations;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    public List<Transaction> parser(List<String> fruitsFromFile) {
        List<Transaction> parser = new ArrayList<>();
        for (int i = 0; i < fruitsFromFile.size(); i++) {
            String[] line = fruitsFromFile.get(i).split(",");
            parser.add(new Transaction(line[0], line[1], Integer.parseInt(line[2]), line[3]));
        }
        return parser;
    }
}
