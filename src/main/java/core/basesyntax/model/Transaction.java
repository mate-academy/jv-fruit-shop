package core.basesyntax.model;

import java.util.Arrays;

public class Transaction {
    private final Fruit fruit;
    private final Type type;

    public Transaction(Fruit fruit, Type type) {
        this.fruit = fruit;
        this.type = type;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String letter;

        Type(String letter) {
            this.letter = letter;
        }

        public String getLetter() {
            return letter;
        }

        public static Transaction.Type getTypeOperation(String letter) {
            return Arrays.stream(Transaction.Type.values())
                    .filter(l -> l.getLetter().equals(letter))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("This letter isn't valid " + letter));
        }
    }
}
