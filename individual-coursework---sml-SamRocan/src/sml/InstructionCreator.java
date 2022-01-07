package sml;

import sml.instructions.BnzInstruction;
import sml.instructions.MulInstruction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


/**
 * This class represents Creates instructions using reflection
 *
 * @author Sam Clendennan
 */
public class InstructionCreator {

    /**
     * Gets arguments from the constructor
     *
     * @param constructor the constructor of the class
     * @param elements elements that make up the constructor
     * @return the parameters for the class
     */
    private static Object[] getConstructArgs(Constructor<?> constructor, ArrayList<String> elements) {
        Class[] paramTypes = constructor.getParameterTypes();

        //If its an int it converts it to one, otherwise it stays as a string
        Object[] parameters = new Object[paramTypes.length];
        for(int i = 0; i<elements.size(); i++){
            try{
                parameters[i]=Integer.parseInt(elements.get(i));
            }
            catch (NumberFormatException e){
                parameters[i]=elements.get(i);
            }
        }

        return parameters;
    }
    /**
     * Creates the instruction
     *
     * @param list a list of parameters to go to the constructor
     * @return a new instance of the relevent instruction class
     */
    static Instruction getInstruction(String[] list){

        ArrayList<String> elements = new ArrayList<>(Arrays.asList(list));
        String opcode = elements.remove(1);
        opcode = opcode.substring(0, 1).toUpperCase() + opcode.substring(1) + "Instruction";
        try{
            // Gets class name
            Class<?> instructionClass = Class.forName("sml.instructions."+opcode);
            // Gets the relevant constructor
            Constructor<Instruction> instructionConstruct = (Constructor<Instruction>) instructionClass.getConstructors()[1];
            // Gets the arguments needed for the constructor
            Object[] constructArgs = getConstructArgs(instructionConstruct, elements);
            //Creates a new instance of the class using the constructor arguments
            return instructionConstruct.newInstance(constructArgs);
            //Catches error if the class name is incorrect or any other error.
        } catch (ClassNotFoundException e) {
            System.out.println("Unable to find Classname'" + "' to handle '" + opcode + "' opcode.");
            return null;
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            return null;
        }

    }
}