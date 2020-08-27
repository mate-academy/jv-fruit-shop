package core.basesyntax.dao;

import core.basesyntax.operation.OperationGeneral;

import java.util.List;

public interface OrderDao<T extends OperationGeneral> {
    void add(T order);

    List<T> getAll();
}
