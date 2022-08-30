package core.basesyntax.service;

import core.basesyntax.model.Transaktion;
import java.util.List;

public interface Parser {
    List<Transaktion> parse(List<String> lines);
}
