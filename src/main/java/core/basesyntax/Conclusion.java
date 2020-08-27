package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class Conclusion {
    public List<List<String>> toGetResult(Storage storage, List<String> types) {
        List<List<String>> conclusionList = new ArrayList<>();
        for (String type : types) {
            List<String> row = new ArrayList<>();
            row.add(type);
            int sumOfType = storage.getFruits()
                    .stream()
                    .filter(position -> position.getType().equals(type))
                    .mapToInt(Fruit::getAmount)
                    .sum();
            row.add(String.valueOf(sumOfType));
            conclusionList.add(row);
        }
        return conclusionList;
    }
}
