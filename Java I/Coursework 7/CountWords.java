// 13706342
// SamClendenan@iCloud.com

import java.io.*;
import java.util.*;

public class CountWords {

    private String inputFileName;
    private String outputFileName;

    public CountWords(String input, String output){
        this.inputFileName = input;
        this.outputFileName = output;
    }

    //Reads file, converts it to a list
    public ArrayList readText(String str) {
        ArrayList list = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(str));
            String line = reader.readLine();
            String lower;
            while (line != null) {
                lower = line.toLowerCase();
                list.add(lower);
                line = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found");
        } catch (IOException e2) {
            System.out.println("IO ERROR");
        }
        return list;
    }

    //counts word and tally's them to a HashMap variable
    public HashMap wordCounter(ArrayList lst){
        String hold = "";
        String word = "";
        int charVal;
        HashMap<String, String> uniqueWords = new HashMap<String, String>();

        for (int x = 0; x < lst.size(); x++) {
            hold += lst.get(x);
            for(int z = 0; z<hold.length(); z++){
                String line  = String.valueOf(x+1);
                charVal = (int) hold.charAt(z);
                if(charVal >  96 && charVal < 123){
                    word+= hold.charAt(z);
                }
                else if(word.length() > 0){
                    boolean hasWord = uniqueWords.containsKey(word);
                    if(hasWord == true && uniqueWords.get(word).contains(line) != true ){uniqueWords.put(word, uniqueWords.get(word) + " " + line );}
                    else{ uniqueWords.put(word, "line(s) " + line);}
                    word = "";
                }
            }
            hold = "";
            word = "";
        }
        return uniqueWords;
    }

    //Returns to file.
    public void toFile(){
        //Prints output to terminal
        ArrayList list = readText(inputFileName);
        HashMap<String, String> uniqueWords = wordCounter(list);

        ArrayList<String> retList = new ArrayList<String>();
        for (String i : uniqueWords.keySet()) {
            retList.add(i + ": " + uniqueWords.get(i));
        }
        Collections.sort(retList);
        for (int out = 0; out<retList.size(); out++){
            System.out.println(retList.get(out));
        }
        //Writes output to file.
        try{
            FileWriter myWriter = new FileWriter(outputFileName);
            for (int out = 0; out<retList.size(); out++){
                myWriter.write(retList.get(out) + "\n");
            }
            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occoured");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CountWords count = new CountWords("test.txt", "outputFinal.txt");
        count.toFile();
    }

}


