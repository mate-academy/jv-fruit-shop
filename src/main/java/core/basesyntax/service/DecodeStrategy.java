package core.basesyntax.service;

import core.basesyntax.model.TypeActivity;

public interface DecodeStrategy {
    TypeActivity get(String shortForm);
}
