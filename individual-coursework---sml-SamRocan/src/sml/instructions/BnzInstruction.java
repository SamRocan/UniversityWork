package sml.instructions;

import sml.Instruction;
import sml.Machine;

import java.awt.*;

/**
 * The Load Instruction class
 *
 * @author ...
 */
public final class BnzInstruction extends Instruction {
    private String label;
    private int register;
    private String label2;

    /**
     * @param lab
     * @param op
     */
    public BnzInstruction(String lab, String op) {
        super(lab, op);
    }

    /**
     * Initialise the instruction
     *
     * @param lab of the instruction
     * @param reg to work with
     *
     */
    public BnzInstruction(String lab, int reg, String lab2) {
        super(lab, "lin");
        this.register = reg;
        this.label2 = lab2;

    }

    /**
     * Execute the instruction in the context of the Machine
     *
     * @param m the machine
     */
    @Override
    public void execute(Machine m) {

        if (m.getRegisters().getRegister(register) != 0) {
            m.setPc(m.getLabels().indexOf(label2));
        }
    }

    /**
     * String representation of the instruction
     *
     * @return incorporating the value
     */
    @Override
    public String toString() {
        return super.toString() + " if the value of the register " + register +
                " isn't zero, then make the statement " + label2 +
                " execute next";
    }
}
