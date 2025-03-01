package core.basesyntax.main;

import core.basesyntax.dataparser.DataParser;
import core.basesyntax.dataparser.DataParserStrategyImpl;
import core.basesyntax.dataparser.ParserModels;
import core.basesyntax.dataprocessor.DataProcessor;
import core.basesyntax.dataprocessor.DataProcessorStrategyImpl;
import core.basesyntax.dataprocessor.ProcessSchema;
import core.basesyntax.dstdao.DestinationDao;
import core.basesyntax.dstdao.DestinationDaoStrategyImpl;
import core.basesyntax.dstdao.DestinationTypes;
import core.basesyntax.reportgenerator.ReportGenerator;
import core.basesyntax.reportgenerator.ReportGeneratorStrategyImpl;
import core.basesyntax.reportgenerator.ReportTemplate;
import core.basesyntax.srcdao.SrcDao;
import core.basesyntax.srcdao.SrcDaoStrategyImpl;
import core.basesyntax.srcdao.SrcTypes;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final SrcTypes DEFINED_SOURCE_TYPE = SrcTypes.FILE;
    private static final String SRC_FILE_PATH
            = ".\\src\\main\\resources\\data_source\\test.txt";
    private static final ParserModels DEFINED_PARSER_MODEL = ParserModels.CSV;
    private static final ProcessSchema DEFINED_PROCESS_SCHEMA = ProcessSchema.REMNANTS;
    private static final ReportTemplate DEFINED_REPORT_TEMPLATE = ReportTemplate.GOODS_FLOW;
    private static final DestinationTypes DEFINED_DST_TYPE = DestinationTypes.FILE;
    private static final String DST_FILE_PATH
            = ".\\src\\main\\resources\\report_destination\\report.txt";

    public static void main(String[] args) {
        SrcDao srcDao = new SrcDaoStrategyImpl().getSrcDao(DEFINED_SOURCE_TYPE);
        List<String> srcContents = new ArrayList<>();
        if (srcDao.openSrc(SRC_FILE_PATH)) {
            if (srcDao.readSrc()) {
                srcContents = srcDao.getSrcContents();
            }
        }
        srcDao.closeSrc(SRC_FILE_PATH);

        DataParser dataParser = new DataParserStrategyImpl().getDataParser(DEFINED_PARSER_MODEL);
        List<String[]> parsedData = dataParser.parseData(srcContents);

        DataProcessor dataProcessor = new DataProcessorStrategyImpl()
                .getDataProcessor(DEFINED_PROCESS_SCHEMA);
        List<String[]> processedData = dataProcessor.processData(parsedData);

        ReportGenerator reportGenerator = new ReportGeneratorStrategyImpl()
                .getReportGenerator(DEFINED_REPORT_TEMPLATE);
        List<String> report = reportGenerator.generateReport(processedData);

        DestinationDao dstDao = new DestinationDaoStrategyImpl().getDstDao(DEFINED_DST_TYPE);
        if (dstDao.openDst(DST_FILE_PATH)) {
            dstDao.writeDst(report);
        }
        dstDao.closeDst(DST_FILE_PATH);
    }
}
