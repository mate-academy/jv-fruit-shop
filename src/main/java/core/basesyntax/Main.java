package core.basesyntax;

import core.basesyntax.service.FruitProcessing;
import core.basesyntax.service.impl.FruitProcessingImpl;

public class Main {
    public static void main(String[] args) {

        FruitProcessing fruitProcessing = new FruitProcessingImpl();
        fruitProcessing.fruitProcessing("inputData.csv");
    }
}
