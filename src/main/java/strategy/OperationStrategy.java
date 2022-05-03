package strategy;

import model.FruitTransferDto;

public interface OperationStrategy {
    void handle(FruitTransferDto dto);
}
