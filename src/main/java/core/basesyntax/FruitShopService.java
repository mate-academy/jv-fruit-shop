package core.basesyntax;

import core.basesyntax.service.CalculatorImpl;
import core.basesyntax.service.ConverterMapToFileStringImpl;
import core.basesyntax.workwithfiles.ReaderImpl;
import core.basesyntax.workwithfiles.WriterImpl;
import java.util.List;
import java.util.Map;

public class FruitShopService {
    private static final ConverterMapToFileStringImpl CONVERTER
            = new ConverterMapToFileStringImpl();
    private static final ReaderImpl READER = new ReaderImpl();
    private static final CalculatorImpl CALCULATOR = new CalculatorImpl();
    private static final WriterImpl WRITER = new WriterImpl();

    void findRestOfFruitsInTheShop(String fromFile, String toFile) {
        List<String> data = READER.read(fromFile);
        Map<String, Integer> calculatedData = CALCULATOR.calculate(data);
        String finalData = CONVERTER.dataToString(calculatedData);
        WRITER.write(finalData,toFile);

    }
}
