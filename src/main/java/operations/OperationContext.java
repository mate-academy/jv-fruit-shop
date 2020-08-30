package operations;

import dto.PositionDto;
import exceptions.NoValidOperationException;
import interfaces.IOperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Position;

public class OperationContext {
    private static final String BUY = "b";
    private static final String RETURN = "r";
    private static final String SUPPLY = "s";

    public boolean operateSwitcher(List<PositionDto> positionDtos) {
        Map<String, IOperationStrategy> operations = new HashMap<>();
        operations.put(BUY, new BuyOperation());
        operations.put(RETURN, new ReturnOperation());
        operations.put(SUPPLY, new SupplyOperation());
        for (PositionDto positionDto : positionDtos) {
            IOperationStrategy strategy = operations.get(positionDto.getOperation());
            if (strategy == null) {
                throw new NoValidOperationException("Operation is not valid");
            }
            strategy.operate(new Position(positionDto.getFruitName(),
                    positionDto.getQuantity(), positionDto.getDate()));
        }
        return true;
    }
}
