package core.basesyntax.service.implementations;

import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CsvToTransactionDtoParserTest {
    public static final List<String> CORRECT_LIST = List.of("b,engine,65536");
    public static final List<String> INVALID_OPERATION_LIST = List.of("z,engine,65536");
    public static final List<String> INVALID_NEGATIVE_VALUE_LIST = List.of("b,engine,-65536");
    public static final List<String> INVALID_EMPTY_ITEM_LIST = List.of("b,,65536");

    public static CsvToTransactionDtoParser parser;

    @BeforeClass
    public static void initialize() {
        parser = new CsvToTransactionDtoParser();
    }

    @Test
    public void validString_Correct() {
        List<TransactionDto> parsed = parser.parse(CORRECT_LIST);
        TransactionDto dto = parsed.get(0);
        Assert.assertEquals(Operation.BALANCE, dto.getOperation());
        Assert.assertEquals("engine", dto.getItem().getName());
        Assert.assertEquals(Integer.valueOf(65536), dto.getQuantity());
    }

    @Test(expected = RuntimeException.class)
    public void invalidOperation_ThrowsException() {
        parser.parse(INVALID_OPERATION_LIST);
    }

    @Test(expected = RuntimeException.class)
    public void emptyItem_ThrowsException() {
        parser.parse(INVALID_EMPTY_ITEM_LIST);
    }
}
