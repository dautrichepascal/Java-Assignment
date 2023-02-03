/*
Author: Pascal d'Autriche (20190826)
Date: 15/10/2021
Purpose: A class to be used to read in the csvFile
*/

import java.util.*;
import java.io.*;

public class FileIO 
{


    /*
    Purpose: Populates the Objects using the CSV File
    Date: 15/10/2021
    Import: None
    Export: covidCaseArray (CovidCase[])
    */

    public CovidCase[] readFile() 
    {   
        // Assigns the fileName in question to the String fileName
        String fileName = fileName();

        // Reads in all the necessary BR methods to be used to read the CSV File
        FileInputStream fileStream = null;
        InputStreamReader rdr;
        BufferedReader bufRdr;

        // Assigns the number of lines within the CSV to the variable numberOfLines
        int numberOfLines = numberOfLines(fileName);

        //Creates array of CovidCases of size number of Lines
        CovidCase[] covidCaseArray;
        covidCaseArray = new CovidCase[numberOfLines];

        try 
        {

            //Define all necessary variables
            fileStream = new FileInputStream(fileName);
            rdr        = new InputStreamReader(fileStream);
            bufRdr     = new BufferedReader(rdr);

            int lineNum = 0;
            int day;
            int month;
            int year;
            int cases;

            Date date;
            CovidCase covidCase = new CovidCase();

            String line = bufRdr.readLine();
            String data[]; 
            String country; 
            String province; 
            String region; 
            String ageGroup; 

            char sex; 

            while(line != null)
            {
                //Skips the first line of the csv with all the headers
                lineNum++;
                if(lineNum > 1)
                {
                    data = line.split(",");

                    if(data.length == 9)
                    {

                        //Assigns each column of the csv to the class fields within the covid case
                        day = Integer.parseInt(data[0]);
                        month = Integer.parseInt(data[1]);
                        year = Integer.parseInt(data[2]);
                        country = data[3];
                        province = data[4];
                        region = data[5];
                        ageGroup = data[6];
                        sex = data[7].charAt(0);
                        cases = Integer.parseInt(data[8]);

                        date = new Date(day, month, year);
                        covidCase = new CovidCase(country, province, region, ageGroup, sex, cases, date);
                        covidCaseArray[lineNum-2] = covidCase;
                    }
                }
                //Reads next line of csv
                line = bufRdr.readLine();
            }
            fileStream.close();
        }
        catch(FileNotFoundException exception)
        {
            System.out.println("Invalid File Name");
            covidCaseArray = null;
        }
        catch(IOException exception)
        {
            if(fileStream != null)
            {
                try
                {
                    fileStream.close();
                }
                catch(IOException ex2)
                {

                }
                System.out.println("Error in file processing: " + exception.getMessage());
            }
        }
        return covidCaseArray;
    }



    /*
    Purpose: Finds the number of lines within the CSV File
    Date: 15/10/2021
    Import: pFileName (String)
    Export: lineNum (int)
    */
    public int numberOfLines(String pFileName)
    {
        // Declare all necessary variables

        String fileName = pFileName;
        FileInputStream fileStream = null;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        int lineNum = 0;

        try
        {
            fileStream = new FileInputStream(fileName);
            rdr        = new InputStreamReader(fileStream);
            bufRdr     = new BufferedReader(rdr);
            String line = bufRdr.readLine();
            

            while (line != null)
            {
                //While there is another line +1 to line num, returns the number of lines within the csv
                lineNum++;

                //Reads next line
                line = bufRdr.readLine();
            }
            fileStream.close();
            

        }
        catch(IOException exception)
        {
            exception.printStackTrace();
        }
        return lineNum;
    }



    /*
    Purpose: Writes the menu output to a log file (.txt)
    Date: 15/10/2021
    Import: String (pOutput)
    Export: None
    */
    public void fileWriter(String pOutput)
    {
        String oToFile = pOutput;

        File fName = new File("Output.txt");

        try
        {
            if(fName.exists() == false)
            {
                fName.createNewFile();
            }
            PrintWriter pw = new PrintWriter(new FileWriter(fName, true));
            //Instead of overwriting file, add output string to file and print new line after
            pw.append(oToFile + '\n');
            pw.close();
        }
        catch(IOException e)
        {
            System.out.println("Could not write to file!");
        }
    }



    /*
    Purpose: Method that allows for ease in transfer between the CSV File's to be read
    Date: 15/10/2021
    Import: None
    Export: fileToRead (String)
    */
    public String fileName()
    {
        String fileToRead = "COVID19BE_CASES.csv";
        return fileToRead;
    }
}