package core.basesyntax;

import core.basesyntax.operations.DataValidator;
import core.basesyntax.exeptions.NotValidDataException;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class DataValidatorTest {

    public final static List<String> INCORRECT_INPUT_DATA = List.of("type,fruit,quantity,date",
            "t,apple,1,2020-10-17");
    public final static List<String> INCORRECT_INPUT_DATA2 = List.of("type,fruit,quantity,date",
            "s,banana,xxx,2020-10-17", "r,apple,1,2020-10-17");
    public final static List<String> INCORRECT_INPUT_DATA3 = List.of("type,fruit,quantity,date",
            "s,banana,100,2020-10-17", "r,apple,1,2020-25-25");
    public final static List<String> INCORRECT_INPUT_DATA5 = List.of("type,fruit,quantity,date",
            "s,banana,100,2020-10-17", "r,apple,1,2020.10.25");
    public final static List<String> INCORRECT_INPUT_DATA6 = List.of();
    public final static List<String> INCORRECT_INPUT_DATA_EMPTY = new ArrayList<>();


    @Test(expected = NotValidDataException.class)
    public void data_Validation_Test_Fail() {
        DataValidator data = new DataValidator();
        data.dataValidation(INCORRECT_INPUT_DATA);
    }

    @Test(expected = NotValidDataException.class)
    public void data_Validation_Test2_Fail(){
        DataValidator data = new DataValidator();
        data.dataValidation(INCORRECT_INPUT_DATA2);
    }

    @Test(expected = NotValidDataException.class)
    public void data_Validation_Test3_Fail() {
        DataValidator data = new DataValidator();
        data.dataValidation(INCORRECT_INPUT_DATA3);
    }

    @Test(expected = NotValidDataException.class)
    public void data_Validation_Test_Empty_Fail() {
        DataValidator data = new DataValidator();
        data.dataValidation(INCORRECT_INPUT_DATA_EMPTY);
    }

    @Test(expected = NotValidDataException.class)
    public void data_Validation_Test5_Fail() {
        DataValidator data = new DataValidator();
        data.dataValidation(INCORRECT_INPUT_DATA5);
    }

    @Test(expected = NotValidDataException.class)
    public void data_Validation_Test6_Fail() {
        DataValidator data = new DataValidator();
        data.dataValidation(INCORRECT_INPUT_DATA6);
    }
}
