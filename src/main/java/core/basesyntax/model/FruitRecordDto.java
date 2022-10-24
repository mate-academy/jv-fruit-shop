package core.basesyntax.model;

import core.basesyntax.operation.OperationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FruitRecordDto {
    private OperationType type;
    private Fruit fruit;
    private int amount;
}
