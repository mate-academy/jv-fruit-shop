package core.basesyntax.model;

public enum Item_Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String code;

        Item_Operation(String code) {
                this.code = code;
        }

        public String getCode() {
                return code;
        }
}
