package core.basesyntax.serviceimpl;

import core.basesyntax.service.ReportMapper;

public class ReportToArrayConverter implements ReportMapper {
    @Override
    public String[] prepareReportForWriting(String report) {
        return report.split("\\n");
    }
}
