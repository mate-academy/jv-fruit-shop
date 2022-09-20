package core.basesyntax.fruitentry;

import core.basesyntax.fruitentrytransaction.FruitEntryTransaction;
import core.basesyntax.fruitentrytransaction.OperationStrategy;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class FruitEntryService {
    private final FruitEntryRepository fruitEntryRepository;
    private final OperationStrategy operationStrategy;

    public void makeTransaction(FruitEntryTransaction transaction) {
        int quantitySign = operationStrategy.get(transaction.getOperation()).getOperationSign();
        int signedQuantityChange = transaction.getQuantity() * quantitySign;
        FruitEntry fruitEntry = fruitEntryRepository.getByFruitName(transaction.getFruitName())
                .orElse(new FruitEntry(transaction.getFruitName()));
        fruitEntry.setQuantity(fruitEntry.getQuantity() + signedQuantityChange);
        fruitEntryRepository.save(fruitEntry);
    }
}
