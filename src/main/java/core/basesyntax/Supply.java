package core.basesyntax;

import core.basesyntax.interfaces.AddFruitsInterface;
import java.util.ArrayList;
import java.util.List;

public class Supply implements AddFruitsInterface<String> {
    @Override
    public List<String> fruitsAdd(String fruitsFromFile, List<String> fruitsAvailable) {
        fruitsAvailable.add(fruitsFromFile);
        return fruitsAvailable;
    }

    @Override
    public List<String> fruitsAddaLL(List<String> fruitsFromFile) {
        List<String> fruitsAvailable = new ArrayList<>();
        for (int i = 0; i < fruitsFromFile.size(); i++) {
            if (fruitsFromFile.get(i).startsWith("s")) {
                fruitsAvailable.add(fruitsFromFile.get(i));
            }
        }
        return fruitsAvailable;
    }
}
