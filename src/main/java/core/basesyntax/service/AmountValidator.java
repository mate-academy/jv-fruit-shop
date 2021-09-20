package core.basesyntax.service;

@FunctionalInterface
public interface AmountValidator {
    boolean compare(Integer value, Integer amount);
}
