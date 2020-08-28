package core.basesyntax;

import core.basesyntax.exeptions.NotEnoughFruitsException;
import core.basesyntax.interfaces.Operation;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RemoveFruit implements Operation {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("uuuu-MM-dd");

    public List<Fruit> operation(List<Fruit> fruitsAvailable, Transaction fruitsFromFile)
            throws NotEnoughFruitsException {
        List<Fruit> fruitsAfterRemove = new ArrayList<>();
        int amountBuying = fruitsFromFile.getAmount();
        if (amountBuying > fruitsAvailable.size()) {
            throw new NotEnoughFruitsException("Not enough fruits to buy.");
        }
        for (int i = 0; i < fruitsAvailable.size(); i++) {
            LocalDate dateOfAvailable = LocalDate.parse(fruitsAvailable
                    .get(i).getExpirationDate(), FORMATTER);
            LocalDate dateOfBuying = LocalDate.parse(fruitsFromFile
                    .getExpirationDate(), FORMATTER);
            if (fruitsFromFile.getTypeOfFruit().equals(fruitsAvailable.get(i).getTypeOfFruit())
                    && (dateOfBuying.isEqual(dateOfAvailable)
                    || dateOfBuying.isBefore(dateOfAvailable))
                    && amountBuying != 0) {
                amountBuying--;
            } else {
                fruitsAfterRemove.add(fruitsAvailable.get(i));
            }
        }
        if (amountBuying != 0) {
            throw new NotEnoughFruitsException("Not enough fruits to buy.");
        }
        fruitsAvailable = fruitsAfterRemove;
        return fruitsAvailable;
    }
}
