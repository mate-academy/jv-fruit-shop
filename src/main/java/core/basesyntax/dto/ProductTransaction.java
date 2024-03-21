package core.basesyntax.dto;

public record ProductTransaction(Operation operation, String product, int quantity) {}
