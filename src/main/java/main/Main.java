package main;

import dataparser.DataParser;
import dataparser.DataParserStrategyImpl;
import dataparser.ParserModels;
import dataprocessor.DataProcessor;
import dataprocessor.DataProcessorStrategyImpl;
import dataprocessor.ProcessSchema;
import dstdao.DstDao;
import dstdao.DstDaoStrategyImpl;
import dstdao.DstTypes;
import java.util.ArrayList;
import java.util.List;
import reportgenerator.ReportGenerator;
import reportgenerator.ReportGeneratorStrategyImpl;
import reportgenerator.ReportTemplate;
import srcdao.SrcDao;
import srcdao.SrcDaoStrategyImpl;
import srcdao.SrcTypes;

public class Main {
    private static final SrcTypes DEFINED_SOURCE_TYPE = SrcTypes.FILE;
    private static final String SRC_FILE_PATH = ".\\src\\main\\resources\\src\\test.txt";
    private static final ParserModels DEFINED_PARSER_MODEL = ParserModels.CSV;
    private static final ProcessSchema DEFINED_PROCESS_SCHEMA = ProcessSchema.REMNANTS;
    private static final ReportTemplate DEFINED_REPORT_TEMPLATE = ReportTemplate.GOODS_FLOW;
    private static final DstTypes DEFINED_DST_TYPE = DstTypes.FILE;
    private static final String DST_FILE_PATH = ".\\src\\main\\resources\\dst\\report.txt";

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

        DstDao dstDao = new DstDaoStrategyImpl().getDstDao(DEFINED_DST_TYPE);
        if (dstDao.openDst(DST_FILE_PATH)) {
            dstDao.writeDst(report);
        }
        dstDao.closeDst(DST_FILE_PATH);
    }
}
