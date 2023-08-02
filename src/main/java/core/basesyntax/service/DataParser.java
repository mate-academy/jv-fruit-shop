package core.basesyntax.service;

import core.basesyntax.model.Activity;
import java.util.List;

public interface DataParser {
    List<Activity> processFile(List<String> listOflines);
}
