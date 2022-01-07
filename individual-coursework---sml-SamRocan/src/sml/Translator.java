package sml;

import sml.instructions.AddInstruction;
import sml.instructions.SubInstruction;
import sml.instructions.MulInstruction;
import sml.instructions.DivInstruction;
import sml.instructions.LinInstruction;
import sml.instructions.OutInstruction;



import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class ....
 * <p>
 * The translator of a <b>S</b><b>M</b>al<b>L</b> program.
 *
 * @author Sam Clendenan
 */
public final class Translator {

  private static final String PATH = "";

  // word + line is the part of the current line that's not yet processed
  // word has no whitespace
  // If word and line are not empty, line begins with whitespace

  private String line = "";
  private final String fileName; // source file of SML code

  public Translator(String file) {
    fileName = PATH + file;
  }

  // translate the small program in the file into lab (the labels) and
  // prog (the program)
  // return "no errors were detected"

  public boolean readAndTranslate(Labels lab, List<Instruction> prog) {
    try (var sc = new Scanner(new File(fileName), "UTF-8")) {
      // Scanner attached to the file chosen by the user
      // The labels of the program being translated
      lab.reset();
      // The program to be created
      prog.clear();
      while (sc.hasNextLine()) {
        String line = sc.nextLine().trim();
        if (line.isEmpty())
          continue;

        String[] elements = line.split("\\s+");

        if (elements.length < 2)
          continue;

        Instruction instruction = InstructionCreator.getInstruction(elements);
        if (instruction != null) {
          lab.addLabel(elements[0]);
          prog.add(instruction);
        }
      }

    } catch (IOException ioE) {
      System.err.println("File: IO error " + ioE);
      return false;
    }
    return true;
  }



}