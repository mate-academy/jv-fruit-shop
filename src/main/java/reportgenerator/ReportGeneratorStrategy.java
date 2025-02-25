package reportgenerator;

public interface ReportGeneratorStrategy {
    ReportGenerator getReportGenerator(ReportTemplate reportTemplate);
}
