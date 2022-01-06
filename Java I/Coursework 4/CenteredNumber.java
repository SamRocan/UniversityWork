// 13706342
// SamClendenan@icloud.com

public class CenteredNumber {
    String retString = "";

    public CenteredNumber( String s )
    {
        String failString = "";
        //Does the String only contain z
        boolean isZ = true;
        int check = 0;
        while (check < s.length()){
            if (s.charAt(check) == 'z'&& isZ == true){;}
            else{
                this.retString += s.charAt(check);
                isZ = false;
            }
            //t’, ‘n’, ‘z’, ‘N’, and ‘T
            if(s.charAt(check) != 't' && s.charAt(check) != 'n' && s.charAt(check) != 'z' && s.charAt(check) != 'N' && s.charAt(check) != 'T'){ failString = "z";}
            check++;

        }
        if(this.retString == ""){this.retString += "z";}
        if(failString == "z"){this.retString = "z";}

    }

    public CenteredNumber( int n )
    {

      
    }

    public void negate()
    {
        //Check to see if it should return "z" or ""
        this.retString = "";
    }

    public void add( CenteredNumber m )
    {
      
    }

    public String toString()
    {
        return this.retString;
    }


    public static void main(String[] args) {
        CenteredNumber centre = new CenteredNumber("z");
        System.out.println(centre.toString());
        CenteredNumber centre2 = new CenteredNumber(42);
        System.out.println(centre2.toString());


    }
}
