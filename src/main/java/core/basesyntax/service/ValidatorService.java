package core.basesyntax.service;

public interface ValidatorService<T> {
    boolean validate(T line);
}
