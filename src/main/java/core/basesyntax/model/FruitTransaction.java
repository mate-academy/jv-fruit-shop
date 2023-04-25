package core.basesyntax.model;

import core.basesyntax.utils.Operation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;
}
