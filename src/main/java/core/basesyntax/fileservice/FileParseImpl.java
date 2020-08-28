package core.basesyntax.fileservice;

import core.basesyntax.model.FruitBatch;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileParseImpl implements FileParse {
    @Override
    public List<FruitBatch> parseList(List<List<String>> listOfLists) {
        if (listOfLists == null) {
            throw new IllegalArgumentException("List is null");
        }
        List<FruitBatch> fruitBatches = new ArrayList<>();
        listOfLists.remove(0);
        for (List<String> list : listOfLists) {
            if (list.size() != 4) {
                throw new IllegalArgumentException("Invalid number of elements");
            }
            fruitBatches.add(new FruitBatch(list.get(0), list.get(1),
                    Integer.parseInt(list.get(2)),
                    LocalDate.parse(list.get(3))));

        }
        return fruitBatches;
    }
}
