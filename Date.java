/*
Author: Pascal d'Autriche (20190826)
Date: 15/10/2021
Purpose: A Date to be used in the FileIO and the CovidCase

*/
public class Date 
{
    // Class Fields

    private int dayOfMonth;
    private int monthOfYear;
    private int year;

    //Default Constructor

    public Date()
    {
        dayOfMonth = 1;
        monthOfYear = 1;
        year = 2020;
    }

    //Alternate Constructor

    public Date(int pDayOfMonth, int pMonthOfYear, int pYear)
    {
        dayOfMonth = pDayOfMonth;
        monthOfYear = pMonthOfYear;
        year = pYear;
    }
    
    //Copy Constructor

    public Date(Date pDate)
    {
        dayOfMonth = pDate.getDayOfMonth();
        monthOfYear = pDate.getMonthOfYear();
        year = pDate.getYear();
    
    }

    // Setter Methods

    public void setDayOfMonth(int pDayOfMonth)
    {
        dayOfMonth = pDayOfMonth;
    }

    public void setMonthOfYear(int pMonthOfYear)
    {
        monthOfYear = pMonthOfYear;
    }

    public void setYear(int pYear)
    {
        year = pYear;
    }


    // Getter Methods
    
    public int getDayOfMonth()
    {
        return dayOfMonth;
    }

    public int getMonthOfYear()
    {
        return monthOfYear;
    }

    public int getYear()
    {
        return year;
    }

    /*
    Purpose: Checks if two objects are equal to one another
    Date: 15/10/2021
    Import: inObject (Object)
    Export: isEqual (Boolean)
    */

    public boolean equals(Object inObject)
    {
        boolean isEqual = false;
        Date inDate = null;
        if(inObject instanceof Date)
        {
            inDate = (Date)inObject;
            if(dayOfMonth == inDate.getDayOfMonth())
                if(monthOfYear == inDate.getMonthOfYear())
                    if(year == inDate.getYear())
                    isEqual = true;
        }
        return isEqual;

    }

    /*
    Purpose: Returns a string representation of the Object
    Date: 15/10/2021
    Import: None
    Export: dateString (String)
    */

    public String toString()
    {
        String dateString;
        dateString = dayOfMonth + "/" + monthOfYear + "/" + year;
        return dateString;
    }
}
