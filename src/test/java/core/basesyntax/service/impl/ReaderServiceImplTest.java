package core.basesyntax.service.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.ReaderService;
import core.basesyntax.strategy.AdditionStrategyImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.ReductionStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;

public class ReaderServiceImplTest {
    public static final String VALID_FILE_DESTINATION = "src\\test\\resource\\test1.csv";
    public static final String WRONG_DATA_FILE_DESTINATION =
            "src\\test\\resource\\wrongDataFile.csv";
    public static final String EMPTY_FILE_DESTINATION = "src\\test\\resource\\emptyFile.csv";
    ReaderService readerService = new ReaderServiceImpl();

    static {
        Map<Operation, OperationStrategy> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.BALANCE, new AdditionStrategyImpl());
        operationStrategyMap.put(Operation.SUPPLY, new AdditionStrategyImpl());
        operationStrategyMap.put(Operation.PURCHASE, new ReductionStrategyImpl());
        operationStrategyMap.put(Operation.RETURN, new AdditionStrategyImpl());
    }

    @Test
    public void validData() {
        List<TransactionDto> testDto = readerService.readData(VALID_FILE_DESTINATION);
        Assert.assertEquals(Operation.BALANCE, testDto.get(1).getOperation());
        Assert.assertEquals(Operation.SUPPLY, testDto.get(2).getOperation());
        Assert.assertEquals(Optional.of(100),
                java.util.Optional.ofNullable(testDto.get(2).getQuantity()));
        Assert.assertEquals(Optional.of(200),
                java.util.Optional.ofNullable(testDto.get(0).getQuantity()));
    }

    @Test
    public void invalidData() {
        List<TransactionDto> testDto = readerService.readData(VALID_FILE_DESTINATION);
        Assert.assertNotEquals(Operation.RETURN, testDto.get(1).getOperation());
        Assert.assertNotEquals(Operation.BALANCE, testDto.get(2).getOperation());
        Assert.assertNotEquals(Optional.of(10),
                java.util.Optional.ofNullable(testDto.get(2).getQuantity()));
        Assert.assertNotEquals(Optional.of(20),
                java.util.Optional.ofNullable(testDto.get(0).getQuantity()));
    }

    @Test(expected = RuntimeException.class)
    public void exceptionWrongDataFile() {
        readerService.readData(WRONG_DATA_FILE_DESTINATION);
    }

    @Test(expected = RuntimeException.class)
    public void exceptionEmptyFile() {
        readerService.readData(EMPTY_FILE_DESTINATION);
    }
}
