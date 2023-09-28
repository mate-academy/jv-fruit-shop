package core.basesyntax.storage;

import java.util.List;

public class PrepareList {
    private static final int TITLE_INDEX = 0;

    public List<String> prepareListWithoutTitle(List<String> listOfFruits) {
        listOfFruits.remove(TITLE_INDEX);
        return listOfFruits;
    }
}
