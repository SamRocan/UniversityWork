import org.junit.Test;
import static org.junit.Assert.assertEquals;

import sml.*;
public class TestSubInstruction {
    @Test
    public void testSubInstruction(){
        Machine m = new Machine();
        Translator t = new Translator("test/resources/subTest.sml");
        t.readAndTranslate(m.getLabels(), m.getProg());
        m.execute();

        assertEquals(23, m.getRegisters().getRegister(8));

    }
}