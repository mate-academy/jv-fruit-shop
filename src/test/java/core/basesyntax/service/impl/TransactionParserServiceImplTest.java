package core.basesyntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.model.Transaction;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class TransactionParserServiceImplTest {
    private static final String VALID_DATA = """
            b,banana,20
            b,apple,100
            s,banana,100
            p,banana,13
            r,apple,10
            p,apple,20
            p,banana,5
            s,banana,50""";

    private final TransactionParserServiceImpl parserService = new TransactionParserServiceImpl();
    private final List<String> validDataList = VALID_DATA.lines().collect(Collectors.toList());
    private final List<String> invalidOperationList = List.of("invalid,apple,10");

    @Test
    void parse_validList_success() {
        List<Transaction> list = parserService.parse(validDataList);
        assertEquals(validDataList.size(), list.size());
    }

    @Test
    void parse_invalidOperation_fail() {
        assertThrows(RuntimeException.class,
                () -> parserService.parse(invalidOperationList));
    }

    @Test
    void parse_emptyList_success() {
        List<Transaction> list = parserService.parse(new ArrayList<>());
        assertEquals(0, list.size());
    }
}
