package core.basesyntax;

import java.util.List;

public interface Storage {

    int getFruit(String fruit);

    void setFruit(String fruit, int quantity);

    List<String> allFruits();
}
