package core.basesyntax.service;

@FunctionalInterface
public interface InputDataValidator<R> {
    String[] validate(R value) throws InputDataErrorException;
}
