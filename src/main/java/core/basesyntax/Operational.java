package core.basesyntax;

import java.time.LocalDate;
import java.util.Map;

public interface Operational<T, M, M1> {

    void operation(Transaction transaction, Map<String, Integer> store,
                   Map<String, LocalDate> expiration);
}
