import org.junit.Test;
import static org.junit.Assert.assertEquals;

import sml.*;
public class TestMulInstruction {
    @Test
    public void testMulInstruction(){
        Machine m = new Machine();
        Translator t = new Translator("test/resources/mulTest.sml");
        t.readAndTranslate(m.getLabels(), m.getProg());
        m.execute();

        assertEquals(40, m.getRegisters().getRegister(26));

    }
}
