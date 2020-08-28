package core.basesyntax.resources;

import core.basesyntax.DataValidator;
import core.basesyntax.exeptions.NotValidDataException;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class DataValidatorTest {

    public final static List<String> INCORRECT_INPUT_DATA = List.of("k,banana,100,2020-10-17",
            "r,apple,1,2020-10-17");
    public final static List<String> INCORRECT_INPUT_DATA2 = List.of("s,banana,xxx,2020-10-17",
            "r,apple,1,2020-10-17");
    public final static List<String> INCORRECT_INPUT_DATA3 = List.of("s,banana,100,2020-10-17",
            "r,apple,1,2020-25-25");
    public final static List<String> INCORRECT_INPUT_DATA5 = List.of("s,banana,100,2020-10-17",
            "r,apple,1,2020.10.25");
    public final static List<String> INCORRECT_INPUT_DATA_EMPTY = new ArrayList<>();


    @Test(expected = NotValidDataException.class)
    public void data_Validation_Test_Fail() throws NotValidDataException {
        DataValidator data = new DataValidator();
        data.dataValidation(INCORRECT_INPUT_DATA);
    }

    @Test(expected = NotValidDataException.class)
    public void data_Validation_Test2_Fail() throws NotValidDataException {
        DataValidator data = new DataValidator();
        data.dataValidation(INCORRECT_INPUT_DATA2);
    }

    @Test(expected = NotValidDataException.class)
    public void data_Validation_Test3_Fail() throws NotValidDataException {
        DataValidator data = new DataValidator();
        data.dataValidation(INCORRECT_INPUT_DATA3);
    }

    @Test(expected = NotValidDataException.class)
    public void data_Validation_Test_Empty_Fail() throws NotValidDataException {
        DataValidator data = new DataValidator();
        data.dataValidation(INCORRECT_INPUT_DATA_EMPTY);
    }

    @Test(expected = NotValidDataException.class)
    public void data_Validation_Test5_Fail() throws NotValidDataException {
        DataValidator data = new DataValidator();
        data.dataValidation(INCORRECT_INPUT_DATA5);
    }

}