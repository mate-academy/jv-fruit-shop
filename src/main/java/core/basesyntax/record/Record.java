package core.basesyntax.record;

import core.basesyntax.model.Product;

public record Record(Operation operation, Product product) implements Operational {}
