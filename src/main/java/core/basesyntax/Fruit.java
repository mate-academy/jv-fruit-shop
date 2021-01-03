package core.basesyntax;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Fruit {
    private String fruitName;
    private LocalDate localDate;
}
