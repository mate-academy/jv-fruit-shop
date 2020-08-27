package core.basesyntax;

import core.basesyntax.interfaces.AddFruitsInterface;
import java.util.List;

public class AddFruit implements AddFruitsInterface<String> {
    @Override
    public List<String> fruitsAdd(String fruitsFromFile, List<String> fruitsAvailable) {
        fruitsAvailable.add(fruitsFromFile);
        return fruitsAvailable;
    }
}
