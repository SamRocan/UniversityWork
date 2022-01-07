import org.junit.Test;
import static org.junit.Assert.assertEquals;

import sml.*;
public class TestBnzInstruction {
    @Test
    public void testBnzInstruction(){
        Machine m = new Machine();
        Translator t = new Translator("test/resources/bnzTest.sml");
        t.readAndTranslate(m.getLabels(), m.getProg());
        m.execute();
        assertEquals(12, m.getRegisters().getRegister(11));

    }
}