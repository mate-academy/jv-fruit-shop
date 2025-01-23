package core.basesyntax.services;

import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final DataProcessorImpl dataProcessorImpl;
    private final ReportGeneratorImpl reportGeneratorImpl;

    public ShopServiceImpl(DataProcessorImpl dataProcessorImpl,
                           ReportGeneratorImpl reportGeneratorImpl) {
        this.dataProcessorImpl = dataProcessorImpl;
        this.reportGeneratorImpl = reportGeneratorImpl;
    }

    @Override
    public String getReport() {
        Map<String, Integer> processedData = dataProcessorImpl.process();
        return reportGeneratorImpl.generate(processedData);
    }
}
