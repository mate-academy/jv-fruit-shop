package core.basesyntax;

import core.basesyntax.model.FruitDto;
import core.basesyntax.parser.FruitDtoParser;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class FruitDtoParserTest {
    private static final String INCORRECT_NUMBER = "s,banana,incorrect,2017-10-12";
    private static final String ROW = "s,banana,100,2017-10-12";
    private static final String INCORRECT_DATE = "s,banana,100,2017-10-35";
    private static final FruitDtoParser PARSER = new FruitDtoParser();

    @Test(expected = IllegalArgumentException.class)
    public void checkParseWithIncorrectNumber() {
        PARSER.parse(INCORRECT_NUMBER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkParseWithIncorrectDate() {
        PARSER.parse(INCORRECT_DATE);
    }

    @Test
    public void checkParseCorrect() {
        FruitDto fruitDto = new FruitDto.FruitDtoBuilder().setTypeOperation("s")
                .setDate(LocalDate.parse("2017-10-12"))
                .setName("banana")
                .setQuantity(100)
                .build();
        Assert.assertEquals(fruitDto, PARSER.parse(ROW));
    }
}
