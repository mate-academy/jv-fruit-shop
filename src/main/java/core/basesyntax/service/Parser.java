package core.basesyntax.service;

import core.basesyntax.model.LineInformation;
import java.util.List;

public interface Parser {
    List<LineInformation> parse(List<String> sourceData);
}
