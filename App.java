import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        //User inputs password
        Scanner input = new Scanner(System.in);
        System.out.print("Enter password: ");
        String password = input.nextLine();
        input.close();

        //Turns string into a character array
        int length = password.length();
        char[] pwArray = new char[length];
        for(int i = 0; i < length; i++)
        {
            pwArray[i] = password.charAt(i);
        }

        //Checks length requirements
        if(length < 8 || length > 16)
        {
            System.out.println("Password does not meet length requirement of 8-16.");
        }

        int requirements = 0; //Counter for how many requirements the password has

        //Checks lowercase requirements
        if(lowerCase(length, pwArray)) //If method returns true...
        {
            requirements++; //increase requirements by 1
        }
        else{
            System.out.println("Password requires at least one lowercase character.");
        }
        
        //Checks uppercase requirements
        if(upperCase(length, pwArray))
        {
            requirements++;
        }
        else{
            System.out.println("Password requires at least one uppercase character.");
        }

        //Checks numbers requirements
        if(numbers(length, pwArray))
        {
            requirements++;
        }
        else{
            System.out.println("Password requires at least one number.");
        }

        //Checks special character requirements
        if(specialCharacters(length, pwArray))
        {
            requirements++;
        }
        else{
            System.out.println("Password requires at least one of the following special characters: ~!@#$%^&*()-=+_");
        }

        if(requirements < 3) //If the password does not meet at least three of the requirements...
        {
            System.out.println("Password does not meet at least three of the requirements.");
        }
        else{
            System.out.print("Password fulfills all requirements!!");
        }
    }

    public static boolean lowerCase(int l, char[] pass) 
    {
        boolean hasLowerCase = false; //Initially, the password has no lowercase characters
        for(int i = 0; i < l; i++) //Traverses character array
        {
            if(pass[i] > 96 && pass[i] < 123) //If the character is between the ASCII values for lowercase characters...
            {
                hasLowerCase = true;
            }
        }

        if(hasLowerCase == false) //If the password has no lowercase characters, return false
        {
            return false;
        }
        else{ //If it does, then return true
            return true;
        }
    }

    public static boolean upperCase(int l, char[] pass) 
    {
        boolean hasUpperCase = false;
        for(int i = 0; i < l; i++)
        {
            if(pass[i] > 64 && pass[i] < 91) //If the character is between the ASCII values for uppercase characters...
            {
                hasUpperCase = true;
            }
        }

        if(hasUpperCase == false)
        {
            return false;
        }
        else{
            return true;
        }
    }

    public static boolean numbers(int l, char[] pass) 
    {
        boolean numbers = false;
        for(int i = 0; i < l; i++)
        {
            if(pass[i] > 47 && pass[i] < 58)  //If the character is between the ASCII values for numbers...
            {
                numbers = true;
            }
        }

        if(numbers == false)
        {
            return false;
        }
        else{
            return true;
        }
    }

    public static boolean specialCharacters(int l, char[] pass) 
    {
        boolean sc = false;
        for(int i = 0; i < l; i++)
        {
            if(pass[i] > 32 && pass[i] < 48) //If the character is between the ASCII values for special characters...
            {
                sc = true;
            }

            if(pass[i] == 64 || pass[i] == 126 || pass[i] == 94 || pass[i] == 61 || pass[i] == 95) //More ASCII SC values
            {
                sc = true;
            }
        }

        if(sc == false)
        {
            return false;
        }
        else{
            return true;
        }
    }


}