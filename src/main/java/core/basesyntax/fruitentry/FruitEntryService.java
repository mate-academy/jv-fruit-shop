package core.basesyntax.fruitentry;

import core.basesyntax.fruitentry.exception.NotEnoughQuantityException;
import core.basesyntax.fruitentrytransaction.FruitEntryTransaction;
import core.basesyntax.fruitentrytransaction.OperationStrategy;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RequiredArgsConstructor
public class FruitEntryService {
    private final FruitEntryRepository fruitEntryRepository;
    private final OperationStrategy operationStrategy;

    public void makeTransaction(FruitEntryTransaction transaction) {
        int quantitySign = operationStrategy.get(transaction.getOperation()).getOperationSign();
        int signedQuantityChange = transaction.getQuantity() * quantitySign;
        FruitEntry fruitEntry = fruitEntryRepository.getByFruitName(transaction.getFruitName())
                .orElse(new FruitEntry(transaction.getFruitName()));
        int newQuantity = fruitEntry.getQuantity() + signedQuantityChange;
        if (newQuantity < 0) {
            throw new NotEnoughQuantityException("Quantity can't be negative");
        }
        fruitEntry.setQuantity(newQuantity);
        fruitEntryRepository.save(fruitEntry);
    }

    public List<FruitEntry> getAllFruitEntries() {
        return fruitEntryRepository.getAll();
    }
}
