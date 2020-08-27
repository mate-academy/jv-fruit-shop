package operations;

import dto.FruitDto;
import exceptions.NoValidOperationException;
import interfaces.OperationStrategy;
import model.Fruit;

public class OperationContext {
    private static final String BUY = "b";
    private static final String RETURN = "r";
    private static final String SUPPLY = "s";
    private OperationStrategy strategy;

    public void operateSwitcher(FruitDto fruitDto) {
        String operation = fruitDto.getOperation();
        switch (operation) {
            case BUY:
                strategy = new BuyOperation();
                break;
            case RETURN:
                strategy = new ReturnOperation();
                break;
            case SUPPLY:
                strategy = new SupplyOperations();
                break;
            default:
                throw new NoValidOperationException("No valid operation!");
        }
        strategy.operate(new Fruit(fruitDto.getFruitName(),
                fruitDto.getQuantity(), fruitDto.getDate()));
    }
}
