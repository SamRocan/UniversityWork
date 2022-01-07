import org.junit.Test;
import static org.junit.Assert.assertEquals;

import sml.*;
public class TestDivInstruction {
    @Test
    public void testDivInstruction(){
        Machine m = new Machine();
        Translator t = new Translator("test/resources/divTest.sml");
        t.readAndTranslate(m.getLabels(), m.getProg());
        m.execute();

        assertEquals(7, m.getRegisters().getRegister(2));

    }
}