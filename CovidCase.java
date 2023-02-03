/*
Author: Pascal d'Autriche (20190826)
Date: 15/10/2021
Purpose: A Covid Case to be used in the FileIO

*/

class CovidCase 
{
    //Class Fields

    private String country;
    private String province;
    private String region;
    private String ageGroup;
    private char sex;
    private int cases;
    private Date date;

    //Default Constructor

    public CovidCase()
    {
        country = "";
        province = "";
        region = "";
        ageGroup = "";
        sex = (char)0;
        cases = 0;
        date = new Date();
    }

    //Alternate Constructor

    public CovidCase(String pCountry, String pProvince, String pRegion, String pAgeGroup, char pSex, int pCases, Date pFinalDate)
    {
        country = pCountry;
        province = pProvince;
        region = pRegion;
        ageGroup = pAgeGroup;
        sex = pSex;
        cases = pCases;
        date = new Date(pFinalDate);
    }

    //Copy Constructor

    public CovidCase(CovidCase pCovidCase)
    {
        country = pCovidCase.getCountry();
        province = pCovidCase.getProvince();
        region = pCovidCase.getRegion();
        ageGroup = pCovidCase.getAgeGroup();
        sex = pCovidCase.getSex();
        cases = pCovidCase.getCases();
        date = pCovidCase.getDate();
    }

    //Setter Methods
    public void setCountry(String pCountry)
    {
        country = pCountry;
    }

    public void setProvince(String pProvince)
    {
        province = pProvince;
    }

    public void setRegion(String pRegion)
    {
        region = pRegion;
    }

    public void setAgeGroup(String pAgeGroup)
    {
        ageGroup = pAgeGroup;
    }

    public void setSex(char pSex)
    {
        sex = pSex;
    }

    public void setCases(int pCases)
    {
        cases = pCases;
    }

    public void setDate(Date pFinalDate)
    {
        date = pFinalDate;
    }

    //Getter Methods

    public String getCountry()
    {
        return country;
    }

    public String getProvince()
    {
        return province;
    }

    public String getRegion()
    {
        return region;
    }

    public String getAgeGroup()
    {
        return ageGroup;
    }

    public char getSex()
    {
        return sex;
    }

    public int getCases()
    {
        return cases;
    }

    public Date getDate()
    {
        return date;
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
        CovidCase inCovidCase = null;
        if(inObject instanceof CovidCase)
        {
            inCovidCase = (CovidCase)inObject;
            if(country.equals(inCovidCase.getCountry()))
                if(province.equals(inCovidCase.getProvince()))
                    if(region.equals(inCovidCase.getRegion()))
                        if(ageGroup.equals(inCovidCase.getAgeGroup()))
                            if(sex == inCovidCase.getSex())
                                if(cases == inCovidCase.getCases())
                                    if(date.equals(inCovidCase.getDate()))
                                    isEqual = true;
        }
        return isEqual;
    }

    /*
    Purpose: Used to convert the objects into a string representation
    Date: 15/10/2021
    Import: None
    Export: str (String)
    */

    public String toString()
    {
        String str;
        String dateStr;
        String country = getCountry();
        String province = getProvince();
        String region = getRegion();
        String ageGroup = getAgeGroup();
        char sex = getSex();
        int cases = getCases();
        Date date = getDate();

        //Combines the to string method from the date class into the string dateStr

        dateStr = date.toString();
        str = country + "," + province + "," + region + "," + ageGroup + "," + sex + "," + cases + "," + dateStr;
        return str;
    }
} 

