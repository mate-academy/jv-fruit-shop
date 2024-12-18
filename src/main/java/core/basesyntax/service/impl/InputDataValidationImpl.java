package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.InputDataValidation;
import java.util.List;

public class InputDataValidationImpl implements InputDataValidation {

    public void validate(List<String> listFromFile) {
        if (listFromFile.stream()
                .filter(s -> s.startsWith(FruitTransaction.Operation.BALANCE.getCode())
                        || s.startsWith(FruitTransaction.Operation.SUPPLY.getCode())
                        || s.startsWith(FruitTransaction.Operation.PURCHASE.getCode())
                        || s.startsWith(FruitTransaction.Operation.RETURN.getCode()))
                .map(s -> s.split(","))
                .map(s -> s[2].toCharArray())
                .flatMap(s -> new String(s).chars().mapToObj(a -> (char) a))
                .anyMatch(Character::isLetter)) {
            throw new RuntimeException("Wrong format in the quantity table");
        }

    }
}
