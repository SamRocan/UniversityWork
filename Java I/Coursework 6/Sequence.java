import java.io.*;
import java.util.*;

public interface Sequence
{
	void push( String st ); // Pushes/adds string to array list
	ArrayList<String> getTopThree(); // Keeps track of lowest 3 strings added to array
	void reset(); //resets the tracking
}