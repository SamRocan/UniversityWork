import org.junit.Test;
import static org.junit.Assert.assertEquals;

import sml.*;
public class TestAddInstruction {
    @Test
    public void testAddInstruction(){
        Machine m = new Machine();
        Translator t = new Translator("test/resources/addTest.sml");
        t.readAndTranslate(m.getLabels(), m.getProg());
        m.execute();

        assertEquals(91, m.getRegisters().getRegister(12));

    }
}