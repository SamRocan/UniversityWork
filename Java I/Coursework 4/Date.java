// 13706342
// SamClendenan@icloud.com

import com.sun.org.apache.xpath.internal.operations.Bool;

public class Date {
    
    public int day;
    public int month;

    Date( int d, int m )
    {
        if((d <= 28) && (m >= 1 && m <= 12)){ this.day = d; this.month =m;}
        else if((d >=29 && d <=30 ) && (m >= 1 && m <= 12 && m != 2)){ this.day = d; this.month =m;}
        else if((d >=30 && d <=31 ) && (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12)){ this.day = d; this.month =m;}
        else{ this.day=1; this.month = 1;}
    }

    void addDays( int n )
    {
        int daysAdded = this.day + n;
        int daysInMonth = 0;
        Boolean loopTrigger = true;

        while(loopTrigger == true || daysInMonth < daysAdded ){
            loopTrigger = false;
            if(this.month == 2){ daysInMonth =28;}
            else if(this.month == 1 ||this.month == 3 || this.month  == 5 || this.month  == 7 || this.month  == 8 || this.month  == 10 || this.month  == 12){ daysInMonth =31;}
            else{daysInMonth =30;}

            if(daysAdded > daysInMonth) {
                daysAdded -=  daysInMonth;
                this.month++;
            }
        }
        this.day = daysAdded;

        if(this.month > 12){ this.day = 1; this.month = 1;}
    }

    public String toString()
    {
        String dayStr = Integer.toString(this.day);
        String monStr = Integer.toString(this.month);
        if(this.day < 10) {dayStr = "0"+this.day;}
        if(this.month < 10) {monStr = "0"+this.month;}
        return (dayStr + "/" + monStr);
    }
}