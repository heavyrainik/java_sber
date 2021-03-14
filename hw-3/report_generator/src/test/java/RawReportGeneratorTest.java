import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RawReportGeneratorTest {
    RawReport checkReport = new RawReport(List.of("name", "age"), List.of("a", "1", "a", "1"));
    List<Owner> testData = Arrays.asList(new Owner("a", 1), new Owner("a", 1));

    RawReportGenerator<Owner> tester;
    RawReport report;

    @BeforeEach
    void setUp() throws IllegalAccessException {
        tester = new RawReportGenerator<>();
        report = tester.generate(testData);
    }

    @Test
    void testRawReportGenerator(){
        assertEquals(report.toString(), checkReport.toString());
    }

    @Test
    void testReportExcelConverter() throws IOException {
        ReportExcelConverter reportGenerator = new ReportExcelConverter();
        reportGenerator.toExcel(report,"Test", "/Users/sad2017/IdeaProjects/sber_hw/report_generator/src/test/resources/test.xlsx");
    }


}