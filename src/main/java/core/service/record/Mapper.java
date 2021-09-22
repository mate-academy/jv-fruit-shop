package core.service.record;

import core.exception.ValidationException;

public interface Mapper<T, U> {
    U map(T value) throws ValidationException;
}
