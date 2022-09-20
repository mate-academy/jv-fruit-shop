package core.basesyntax.fruitentrytransaction;

import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FruitEntryTransaction {
    private final Operation operation;
    private final String fruitName;
    private final int quantity;

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String name;

        Operation(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public static Optional<Operation> findByName(String name) {
            for (Operation operation : Operation.values()) {
                if (operation.name.equals(name)) {
                    return Optional.of(operation);
                }
            }
            return Optional.empty();
        }
    }
}
