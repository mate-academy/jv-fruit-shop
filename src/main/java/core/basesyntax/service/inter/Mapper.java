package core.basesyntax.service.inter;

public interface Mapper<T, U> {
    U map(String value);
}
