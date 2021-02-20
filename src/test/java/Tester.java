import org.junit.Test;

import static org.junit.Assert.assertSame;

public class Tester {
    public String filename = "D:\\Programming\\java_sber\\java_sber\\src\\main\\resources\\test1.json";
    @Test
    public void testSwitchCaseInitializator() {
        InitializatorSwitchCase init = new InitializatorSwitchCase(filename);
        var client = init.createClient();

        if (client instanceof Holding) {
            assertSame(((Holding) client).getClientType(), ClientTypes.HOLDING);
        } else if (client instanceof Individual) {
            assertSame(((Individual)client).getClientType(), ClientTypes.INDIVIDUAL);
        } else if (client instanceof LegalEntity) {
            assertSame(((LegalEntity) client).getClientType(), ClientTypes.LEGAL_ENTITY);
        } else {
            System.out.print("Creation error");
        }
    }

    @Test
    public void testEnumCaseInitializator() {
        InitializatorEnumCase init = new InitializatorEnumCase(filename);
        var client = init.createClient();

        if (client instanceof Holding) {
            assertSame(((Holding) client).getClientType(), ClientTypes.HOLDING);
        } else if (client instanceof Individual) {
            assertSame(((Individual)client).getClientType(), ClientTypes.INDIVIDUAL);
        } else if (client instanceof LegalEntity) {
            assertSame(((LegalEntity) client).getClientType(), ClientTypes.LEGAL_ENTITY);
        } else {
            System.out.print("Creation error");
        }
    }
}
