package core.basesyntax;

import core.basesyntax.interfaces.AddFruitsInterface;
import java.util.List;

public class AddFruit implements AddFruitsInterface<String> {
    private static Storage range = new Storage();
    private static List<String> fruitsAvailable = range.getFruitTypes();

    @Override
    public List<String> fruitsAdd(String fruitsFromFile) {
        fruitsAvailable.add(fruitsFromFile);
        return fruitsAvailable;
    }
}
