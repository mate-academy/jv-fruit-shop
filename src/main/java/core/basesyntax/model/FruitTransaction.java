package core.basesyntax.model;

public record FruitTransaction(Operation operation,
                               String fruit, int quantity) {
    public enum Operation {
      BALANCE("b"),
      SUPPLY("s"),
      PURCHASE("p"),
      RETURN("r");

        private final String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}
