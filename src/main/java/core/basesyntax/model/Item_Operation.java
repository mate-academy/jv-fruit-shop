package core.basesyntax.model;

import core.basesyntax.exception.WrongOperationException;

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

        public static Item_Operation fromCode(String code) {
                for (Item_Operation operation: Item_Operation.values()) {
                        if (operation.getCode().equals(code)) {
                                return operation;
                        }
                }
                throw new WrongOperationException("Invalid operation code:" + code);
        }
}
