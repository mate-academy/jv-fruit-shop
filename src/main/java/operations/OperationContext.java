package operations;

import dto.PositionDto;
import exceptions.NoValidOperationException;
import interfaces.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Position;

public class OperationContext {
    static Map<String, OperationStrategy> operations = new HashMap<>();
    private static final String BUY = "b";
    private static final String RETURN = "r";
    private static final String SUPPLY = "s";

    static {
        operations.put(BUY, new BuyOperation());
        operations.put(RETURN, new ReturnOperation());
        operations.put(SUPPLY, new SupplyOperation());
    }

    public boolean operateSwitcher(List<PositionDto> positionDtos) {
        for (PositionDto positionDto : positionDtos) {
            OperationStrategy strategy = operations.get(positionDto.getOperation());
            if (strategy == null) {
                throw new NoValidOperationException("Operation is not valid");
            }
            strategy.operate(new Position(positionDto.getFruitName(),
                    positionDto.getQuantity(), positionDto.getDate()));
        }
        return true;
    }
}
