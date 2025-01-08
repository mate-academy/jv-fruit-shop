package core.basesyntax.utils.impl;

import core.basesyntax.model.ResultData;
import core.basesyntax.utils.ReportGenerator;
import java.util.List;

public class ReportGeneratorImpl implements ReportGenerator {

    @Override
    public String getReport(List<ResultData> resultDataList) {
        StringBuilder stringBuilder = new StringBuilder("fruit,quantity\n");
        for (ResultData resultData : resultDataList) {
            stringBuilder.append("%s,%d\n".formatted(
                    resultData.getFruitName(),
                    resultData.getQuantity()));
        }
        return stringBuilder.toString();
    }
}
