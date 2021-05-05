package core.basesyntax.strategy;

import core.basesyntax.dto.ProductDto;
import core.basesyntax.operations.AddOperation;
import core.basesyntax.operations.BalanceOperation;
import core.basesyntax.operations.Operation;
import core.basesyntax.operations.PurchaseOperation;
import java.util.List;

public class OperationStrategy {
    public void doAction(List<ProductDto> productDtoList) {
        Operation purchaseOperation = new PurchaseOperation();
        Operation addOperation = new AddOperation();
        Operation balanceOperation = new BalanceOperation();

        for (ProductDto productDto : productDtoList) {
            switch (productDto.getOperationType()) {
                case "b":
                    balanceOperation.apply(productDto);
                    break;
                case "r":
                case "s":
                    addOperation.apply(productDto);
                    break;
                case "p":
                    purchaseOperation.apply(productDto);
                    break;
                default:
                    throw new RuntimeException("Invalid operation");
            }
        }
    }
}
