import org.junit.Test;

import static org.junit.Assert.assertSame;

public class ClientCreatorImplementationsTester {
    public String filename = "test1.json";
    @Test
    public void testSwitchCaseClientCreator() throws Exception {
        ClientCreatorSwitchCase init = new ClientCreatorSwitchCase(filename);
        var client = init.createClient();

        if (client instanceof Holding) {
            assertSame(((Holding) client).getClientType(), ClientTypes.HOLDING);
        } else if (client instanceof Individual) {
            assertSame(((Individual) client).getClientType(), ClientTypes.INDIVIDUAL);
        } else if (client instanceof LegalEntity) {
            assertSame(((LegalEntity) client).getClientType(), ClientTypes.LEGAL_ENTITY);
        } else {
            throw new Exception("Creation error");
        }
    }

    @Test
    public void testEnumCaseClientCreator() throws Exception {
        ClientCreatorEnumCase init = new ClientCreatorEnumCase(filename);
        var client = init.createClient();

        if (client instanceof Holding) {
            assertSame(((Holding) client).getClientType(), ClientTypes.HOLDING);
        } else if (client instanceof Individual) {
            assertSame(((Individual)client).getClientType(), ClientTypes.INDIVIDUAL);
        } else if (client instanceof LegalEntity) {
            assertSame(((LegalEntity) client).getClientType(), ClientTypes.LEGAL_ENTITY);
        } else {
            throw new Exception("Creation error");
        }
    }
}
