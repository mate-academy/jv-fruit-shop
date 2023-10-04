package core.basesyntax.model;

import java.util.Arrays;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class FruitTransaction {
    private final Operation operation;
    private final String fruit;
    private final int quantity;

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private static final String INVALID_CODE_EXCEPTION = "Invalid code!";
        private final String code;

        Operation(String code) {
            this.code = code;
        }

        public static Operation byCode(String code) {
            return Arrays.stream(Operation.values())
                .filter(o -> code.equalsIgnoreCase(o.code))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(INVALID_CODE_EXCEPTION));
        }
    }

}
