package core.basesyntax.service;

@FunctionalInterface
public interface DataValidator<R> {
    String[] validate(R value) throws ValidationException;
}
