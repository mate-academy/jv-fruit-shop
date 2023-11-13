package core.basesyntax.fruitentry;

import core.basesyntax.fruitentry.exception.NotEnoughQuantityException;
import core.basesyntax.fruitentrytransaction.FruitEntryTransaction;
import core.basesyntax.fruitentrytransaction.OperationStrategy;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FruitEntryService {
    private final FruitEntryRepository fruitEntryRepository;
    private final OperationStrategy operationStrategy;

    public void applyTransaction(FruitEntryTransaction transaction) {
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

    public void applyAllTransactions(List<FruitEntryTransaction> fruitEntryTransactions) {
        fruitEntryTransactions.forEach(this::applyTransaction);
    }

    public List<FruitEntry> getAllFruitEntries() {
        return fruitEntryRepository.getAll();
    }
}
