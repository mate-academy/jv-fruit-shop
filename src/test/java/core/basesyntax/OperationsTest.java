package core.basesyntax;

import dto.PositionDto;
import operations.OperationContext;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OperationsTest {
    private static final String BUY_OPERATION = "s";
    private static final String FRUIT_NAME = "kiwi";
    private static final int QUANTITY = 12;
    private static final LocalDate DATE = LocalDate.parse("2020-12-12");

    private static List<PositionDto> positionDtos;
    private static OperationContext operationContext;

    @BeforeClass
    public static void setUp(){
        PositionDto positionDto = new PositionDto(BUY_OPERATION, FRUIT_NAME,
                QUANTITY, DATE);
        positionDtos = new ArrayList<>();
        positionDtos.add(positionDto);
        operationContext = new OperationContext();
    }

    @Test
    public void operatorSwitcherTest() {
        Assert.assertTrue(operationContext.operateSwitcher(positionDtos));
    }
}
