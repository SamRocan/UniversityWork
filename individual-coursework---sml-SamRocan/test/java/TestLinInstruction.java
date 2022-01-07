import org.junit.Test;
import static org.junit.Assert.assertEquals;

import sml.*;
public class TestLinInstruction {
    @Test
    public void testLinInstruction(){
        Machine m = new Machine();
        Translator t = new Translator("test/resources/linTest.sml");
        t.readAndTranslate(m.getLabels(), m.getProg());
        m.execute();

        assertEquals(46, m.getRegisters().getRegister(2));
        assertEquals(2, m.getRegisters().getRegister(10));

    }
}