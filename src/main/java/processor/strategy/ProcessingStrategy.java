package processor.strategy;

import model.Operation;

public interface ProcessingStrategy {
    void makeTransaction(Operation operation);
}
