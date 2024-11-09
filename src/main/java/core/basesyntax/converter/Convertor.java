package core.basesyntax.converter;

public interface Convertor<T> {
    T parseMethod(String string);
}
