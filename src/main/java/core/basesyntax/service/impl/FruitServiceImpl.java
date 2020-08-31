package core.basesyntax.service.impl;

import core.basesyntax.model.FruitDto;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FruitService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {

    @Override
    public Map<String, Integer> getAvailableFruits(List<FruitDto> fruitDtos) {
        Map<String, Integer> stockBalance = new HashMap<>();
        for (int i = 0; i < fruitDtos.size(); i++) {
            FruitDto fruitDto = fruitDtos.get(i);
            String fruit = fruitDto.getFruit();

            Integer integer = stockBalance.get(fruit);
            if (fruitDto.getOperation() == Operation.BUY && integer < fruitDto.getQuantity()) {
                throw new RuntimeException("The report is wrong. It is impossible to buy "
                        + fruitDto.getQuantity() + fruit + "s.");
            }

            stockBalance.merge(fruit, fruitDto.getQuantity(),
                    (stockQuantity, transactionQuantity)
                            -> fruitDto.getOperation() == Operation.BUY
                            ? stockQuantity - transactionQuantity
                            : stockQuantity + transactionQuantity);
        }
        return stockBalance;
    }
}
