package service;

import model.Fruit;

public interface OperationStrategy {
    Fruit update(Fruit fruit);
}
