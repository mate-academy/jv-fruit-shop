package core.basesyntax.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import core.basesyntax.service.impl.TransactionParserImpl;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TransactionParserTest {
    private TransactionParser parser;

    @BeforeEach
    void setUp() {
        parser = new TransactionParserImpl();
    }

    @Test
    void parseData_notValidData_notOk() {
        TransactionParser transactionParser = new TransactionParserImpl();
        List<String> invalidData = Arrays.asList("BALANCE,banana,-10");

        assertThrows(RuntimeException.class, () -> transactionParser.parseData(invalidData));
    }

    @Test
    void parse_dataIsNull_notOk() {
        List<String> dataForParsing = null;
        assertThrows(RuntimeException.class, () -> parser.parseData(dataForParsing));
    }
}
