package core.basesyntax.service;

import core.basesyntax.Fruit;
import java.time.LocalDate;

public interface Operational {

    void apply(Fruit fruit);

    boolean enoughFresh(String name, LocalDate date, int demand);
}
