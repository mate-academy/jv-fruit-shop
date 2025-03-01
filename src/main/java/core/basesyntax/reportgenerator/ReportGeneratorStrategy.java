package core.basesyntax.reportgenerator;

public interface ReportGeneratorStrategy {
    ReportGenerator getReportGenerator(ReportTemplate reportTemplate);
}
