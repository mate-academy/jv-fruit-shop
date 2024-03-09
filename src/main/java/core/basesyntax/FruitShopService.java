package core.basesyntax;

import core.basesyntax.service.CalculatorImpl;
import core.basesyntax.workwithfiles.ReaderImpl;
import core.basesyntax.workwithfiles.WriterImpl;
import java.util.List;
import java.util.Map;

public class FruitShopService {
    private static final ReaderImpl reader = new ReaderImpl();
    private static final CalculatorImpl calculator = new CalculatorImpl();
    private static final WriterImpl writer = new WriterImpl();

    void findRestOfFruitsInTheShop(String fromFile, String toFile) {
        List<String[]> data = reader.read(fromFile);
        Map<String, Integer> calculatedData = calculator.calculate(data);
        writer.write(calculatedData,toFile);

    }
}
