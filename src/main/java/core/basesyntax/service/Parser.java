package core.basesyntax.service;

import java.util.List;

public interface Parser {

    abstract List<String> parseLine(String line);
}
