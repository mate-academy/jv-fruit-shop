package core.basesyntax.dao;

import core.basesyntax.model.Product;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static final List<Product> FRUIT_LIST = new ArrayList<>();

    static List<Product> getFruitList() {
        return FRUIT_LIST;
    }

    public static void sortList() {
        FRUIT_LIST.sort((e1, e2) ->
                e1.getExDate().isBefore(e2.getExDate()) ? -1
                        : e1.getExDate().isAfter(e2.getExDate())
                        ? 1 : 0);
    }
}
