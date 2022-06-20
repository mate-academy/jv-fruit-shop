package core.basesyntax.service;

import core.basesyntax.modelfruit.ModelFruit;
import java.util.List;

public interface ParceData {
    List<ModelFruit> getFruitsMoving(List<String> list);
}
