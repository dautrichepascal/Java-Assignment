/*
Author: Pascal d'Autriche (20190826)
Date: 15/10/2021
Purpose: The Menu System that the User Interacts with in the Terminal

*/

import java.util.*;
import java.io.*;

public class Menu 
{
    
    
    /*
    Purpose: Is the over all menu system that will be displayed to the user
    Date: 15/10/2021
    Import: None
    Export: None
    */

    public void usersMenu() 
    {
        char Userinput;
        boolean valid = false;
        Scanner sc = new Scanner(System.in);
        
        //Allows for menu system to keep looping until valid = true
        while(!valid)
        {
            System.out.println("\n\nWelcome to the COVID-19 Data Analysis Program. Make a selection from the menu below regarding the information you would like to see:\n\nPlease select from the menu below\n> 1. Statistis of entire nation\n> 2. Statistics of regions\n> 3. Exit the program.");
            Userinput = sc.next().charAt(0);

            switch(Userinput)
            {
                //Case 1 calls Method menuOptionOne
                case '1':
                    System.out.println("\nYour Choice: " + Userinput);
                    menuOptionOne();
                    valid = false;
                    break;
                //Case 2 calls Method menuOptionTwo
                case '2':
                    System.out.println("\nYour Choice: " + Userinput);
                    menuOptionTwo();
                    valid = false;
                    break;
                //Case 3 Exits the whole program as valid will = true
                case '3':
                    System.out.println("\nYour Choice: " + Userinput);
                    System.out.println("\n\nHave a Nice Day !");
                    valid = true;
                    break;
                //If 1,2 or 3 is not entered in, the print statement will print
                default:
                    System.out.println("Invalid Input Please Try Again!!");
                    valid = false;
            }

        }sc.close();
    }    


    /*
    Purpose: Contains the first choice from the menu option that the user will see
    Date: 15/10/2021
    Import: None
    Export: None
    */

    public void menuOptionOne()
    {
        //Declaring all necessary variables

        char genders = (char)0;
        String data = "";
        String fileOutput = "";

        boolean proposeRepetition = false;
        boolean exitLoop = false;
        boolean validation = false;
        boolean exValid = false;

        char exitMethod;
        int choice = 0;
        int numLines = 0;
        int sumCases;
        
        //Assigns variable 'fIO' for the FileIO class, so the methods can be called with ease
        FileIO fIO = new FileIO();
        CovidCase covidCase[] = fIO.readFile();
        Scanner sc = new Scanner(System.in);

        //Assigns number of lines to what the numberOfLines method within the FileIO class returns (int)
        numLines = fIO.numberOfLines(fIO.fileName());
        do
        {
            do
            {
                //Print statement that is displayed if menuOptionOne is called
                System.out.println("\nStatistics for the entire nation: select from the menu below:");
                System.out.println("> 1. Display the total number of COVID-19 cases.");
                System.out.println("> 2. Display the number of COVID-19 cases: Males.");
                System.out.println("> 3. Display the number of COVID-19 cases: Females.");
                System.out.println("> 4. Display the number of COVID-19 cases: 0-9 age group.");
                System.out.println("> 5. Display the number of COVID-19 cases: 10-19 group.");
                System.out.println("> 6. Display the number of COVID-19 cases: 20-29 group.");
                System.out.println("> 7. Display the number of COVID-19 cases: 30-39 group.");
                System.out.println("> 8. Display the number of COVID-19 cases: 40-49 group.");
                System.out.println("> 9. Display the number of COVID-19 cases: 50-59 group.");
                System.out.println("> 10. Display the number of COVID-19 cases: 60-69 group.");
                System.out.println("> 11. Display the number of COVID-19 cases: 70-79 group.");
                System.out.println("> 12. Display the number of COVID-19 cases: 80-89 group.");
                System.out.println("> 13. Display the number of COVID-19 cases: 90+ age group.\n");

                exValid = false;
                while(!exValid)
                {
                    try {
                        choice = sc.nextInt();
                        exValid = true;
                        } catch (InputMismatchException e)
                        { 
                            System.out.println("\nPlease enter an integer!"); 
                            sc.nextLine();
                        }
                }
                

                switch(choice)
                {
                    // Assigns variable genders to the appropriate string, dependent on what user inputs on line 120

                    case 1:
                    exitLoop = false;
                    break;

                    case 2:
                    genders = 'M';
                    exitLoop = false;
                    break;

                    case 3:
                    genders = 'F';
                    exitLoop = false;
                    break;

                    case 4:
                    data = "0-9";
                    exitLoop = false;
                    break;
                    
                    case 5:
                    data = "10-19";
                    exitLoop = false;
                    break;

                    case 6:
                    data = "20-29";
                    exitLoop = false;
                    break;

                    case 7:
                    data = "30-39";
                    exitLoop = false;
                    break;

                    case 8:
                    data = "40-49";
                    exitLoop = false;
                    break;

                    case 9:
                    data = "50-59";
                    exitLoop = false;
                    break;

                    case 10:
                    data = "60-69";
                    exitLoop = false;
                    break;

                    case 11:
                    data = "70-79";
                    exitLoop = false;
                    break;

                    case 12:
                    data = "80-89";
                    exitLoop = false;
                    break;

                    case 13:
                    data = "90+";
                    exitLoop = false;
                    break;

                    default:
                    System.out.println("\n\nInvalid Input Please Try Again!!\n");
                    exitLoop = true;
                }
                //Do while loop that keeps looping until exitLoop = false
            }while(exitLoop);

            sumCases = 0;

            //If the users input is 2 or 3, this statement will enter
            if(choice == 2 || choice == 3)
            {
                for(int i = 0; i < numLines - 1; i++)
                {
                    if((covidCase[i].getSex()) == genders)
                    {
                        sumCases += covidCase[i].getCases();
                    }
                }

                if(choice == 2)
                {
                    data = "Male";
                }

                else
                {
                    data = "Female";
                }

                System.out.println("\nYour Choice: " + choice);

                fileOutput = "Total number of cases for " + data + ": " + sumCases;
                System.out.println(fileOutput);
                fIO.fileWriter(fileOutput);
            }

            //if the users input is inbetween 3 and 14, the program will enter this else if statement
            else if(choice > 3 && choice < 14)
            {
                for(int i = 0; i < numLines-1; i++)
                {   
                    if((covidCase[i].getAgeGroup()).equals(data))
                    {
                        sumCases += covidCase[i].getCases();
                    }
                }
                System.out.println("\nYour Choice: " + choice);
                fileOutput = "Total number of cases for " + data + ": " + sumCases;

                System.out.println(fileOutput);
                fIO.fileWriter(fileOutput);

            }

            //Else, the user entered 1, and the program will enter this if statement
            else
            {
                for(int i = 0; i < numLines-1; i++)
                {
                    sumCases += covidCase[i].getCases();
                }
                System.out.println("\nYour Choice: " + choice);
                fileOutput = "Total number of cases: " + sumCases;

                System.out.println(fileOutput);
                fIO.fileWriter(fileOutput);
            }

            //While loop used to continue looping through the section below until Y/yr N/n is entered
            validation = false;
            while(!validation)
            {
                System.out.println("\n\nWould you like to make another selection (Y or N)?\n");
                exitMethod = sc.next().charAt(0);

                switch(exitMethod)
                {
                    case 'Y': case 'y':
                        validation = true;
                        proposeRepetition = false;
                        break;

                    case 'N': case 'n':
                        proposeRepetition = true;
                        validation = true;
                        break;

                    default:
                        System.out.println("\nInvalid Input Please Try Again!\n");
                        validation = false;
                }

            }
        }while(!proposeRepetition);
    }
    

    /*
    Purpose: Contains the second choice from the menu option that the user will see
    Date: 15/10/2021
    Import: None
    Export: None
    */
    public void menuOptionTwo()
    {
        //Declare all necessary variables
        int selection = 0;
        int netCases = 0;
        int numLines = 0;

        String desiredRegion;
        String ageRange;
        String fileOutput;

        char desireRepetition;

        boolean valid = false;
        boolean repetition = false;
        boolean exValid = false;

        // Assigns the class FileIO to the variable fIO, to make it easier to call its methods
        FileIO fIO = new FileIO();
        CovidCase covidCase[] = fIO.readFile();

        Scanner sc = new Scanner(System.in);

        //Method numberOfLines within fIO is  assigned to the variable numLines
        numLines = fIO.numberOfLines(fIO.fileName());

        while(!valid)
        {
                selection = 0;
                //While loop that will keep looping until a number between 1 and 4 inclusive is entered
                while(selection < 1 || selection > 4)
                {
                    exValid = false;
                    while(!exValid)
                    {
                        try{
                            System.out.println("\nStatistics by Region: select from the menu below:");
                            System.out.println("which region would you like statistics from?\n\n1. Flanders\n2. Brussels\n3. Wallonia\n4. Unknown");
                            selection = sc.nextInt();

                            if(selection > 5 || selection < 0)
                            {
                                System.out.println("Invalid input please try again !!");
                            }
                            exValid = true;
                        }catch(InputMismatchException e)
                        {
                            System.out.println("\nPlease enter an integer!");
                            sc.nextLine();
                        }
                    }
                }

            System.out.println("\nYour Choice: " + selection);

            if(selection == 1)
            {
                desiredRegion = "Flanders";
            }

            else if(selection == 2)
            {
                desiredRegion = "Brussels";
            }
            else if(selection == 3)
            {
                desiredRegion = "Wallonia";
            }
            else
            {
                desiredRegion = "NA";
            }

            //For loop that iterates throughout region collumn of covidCaseArray and sums the number of cases
            for(int i = 0; i<numLines-1; i++)
            {
                if(covidCase[i].getRegion().equals(desiredRegion))
                {
                    netCases += covidCase[i].getCases();
                }
            }
            fileOutput = "Total number COVID-19 cases for " + desiredRegion + " is: " + netCases;
            System.out.println(fileOutput);
            fIO.fileWriter(fileOutput);


            //For loop that loops through the region collumn and sex(male) collumn and if both are equal to the desired outcome, will sum the number of cases.
            for(int i = 0; i<numLines-1; i++)
            {
                if((covidCase[i].getRegion().equals(desiredRegion)) && (covidCase[i].getSex() == 'M'))
                {
                    netCases += covidCase[i].getCases();
                }
            }
            fileOutput = "Total number COVID-19 male cases for " + desiredRegion + " is: " + netCases;
            System.out.println(fileOutput);
            fIO.fileWriter(fileOutput);

            // For loop that loops through the region collumn and sex(female) collumn and if both are equal to the desired outcome, will sum the number of cases
            for(int i = 0; i<numLines-1; i++)
            {
                if((covidCase[i].getRegion().equals(desiredRegion)) && (covidCase[i].getSex() == 'F'))
                {
                    netCases += covidCase[i].getCases();
                }
            }
            fileOutput = "Total number COVID-19 female cases for " + desiredRegion + " is: " + netCases;
            System.out.println(fileOutput);
            fIO.fileWriter(fileOutput);

            //The following call the sumForAges Variable
            ageRange = "0-9";
            sumForAges(ageRange, desiredRegion);

            ageRange = "10-19";
            sumForAges(ageRange, desiredRegion);

            ageRange = "20-29";
            sumForAges(ageRange, desiredRegion);

            ageRange = "30-39";
            sumForAges(ageRange, desiredRegion);

            ageRange = "40-49";
            sumForAges(ageRange, desiredRegion);

            ageRange = "50-59";
            sumForAges(ageRange, desiredRegion);

            ageRange = "60-69";
            sumForAges(ageRange, desiredRegion);

            ageRange = "70-79";
            sumForAges(ageRange, desiredRegion);

            ageRange = "80-89";
            sumForAges(ageRange, desiredRegion);

            ageRange = "90+";
            sumForAges(ageRange, desiredRegion);

            repetition = false;
            while(!repetition)
            {
                System.out.println("\n\nWould you like to make another selection (Y or N): ");
                desireRepetition = sc.next().charAt(0);
                
                switch(desireRepetition)
                {
                    case 'Y': case 'y':
                    repetition = true;
                    valid = false;
                    break;

                    case 'N': case 'n':
                    valid = true;
                    repetition = true;
                    break;

                    default:
                    System.out.println("\nInvalid Choice Please Try Again!");

                }
            }
        }
    }


    /*
    Purpose: Method that returns the sum for every age for the region selected
    Date: 15/10/2021
    Import: pAgeRange(String)
            pRegionOfInterest (String)
    Export: None
    */
    private static void sumForAges(String pAgeRange, String pRegionOfInterest)
    {
        //Declares all the necessary variables
        String ageRange = pAgeRange;
        String regionRequested = pRegionOfInterest;
        String fileOutput;

        int numLines = 0;
        int totalCases = 0;

        FileIO fIO = new FileIO();
        CovidCase covidCase[] = fIO.readFile();

        numLines = fIO.numberOfLines(fIO.fileName());
        
        //For loop that will loop through the region and age group collumn and if both are equal to the desired outcome, only then will the number of cases be added.
        for(int i = 0; i < numLines-1; i++)
        {
            if(((covidCase[i]).getRegion().equals(regionRequested)) && (covidCase[i].getAgeGroup().equals(ageRange)))
            {
                totalCases += covidCase[i].getCases();
            }
        }
        fileOutput = "Total number COVID-19 cases in " + ageRange +  " age group for " + regionRequested + " is: " + totalCases;
        System.out.println(fileOutput);
        fIO.fileWriter(fileOutput);
    }
}
