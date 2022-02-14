package core.basesyntax.service.inter;

public interface Validator<T> {
    void validate(T value) throws RuntimeException;
}
