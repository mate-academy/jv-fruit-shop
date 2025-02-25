package reportgenerator;

import java.util.HashMap;
import java.util.Map;

public class ReportGeneratorStrategyImpl implements ReportGeneratorStrategy {
    private final Map<ReportTemplate, ReportGenerator> reportGenerators;

    public ReportGeneratorStrategyImpl() {
        reportGenerators = new HashMap<>();
        reportGenerators.put(ReportTemplate.GOODS_FLOW, new GoodsflowReportGenerator());
        reportGenerators.put(ReportTemplate.CASH_FLOW, null);
        reportGenerators.put(ReportTemplate.FIN_RES, null);
        reportGenerators.put(ReportTemplate.PLAN_FACT, null);
    }

    @Override
    public ReportGenerator getReportGenerator(ReportTemplate reportTemplate) {
        return reportGenerators.get(reportTemplate);
    }
}
