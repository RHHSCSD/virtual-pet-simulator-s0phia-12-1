/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package virtualpet;
import java.util.*;
/*
 * @author Sophia Guo
 */
public class VirtualPet {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rd = new Random();
        
        //welcome screen
        System.out.println("      o---o");
        System.out.println("     ('(Y)')");
        System.out.println("    c(\")_(\")");
        System.out.println("Welcome to Critterland!");
        
        //login 
        final String username = "snoopy";
        final String password = "toto";
        
        //login system
        boolean passedLogin = false;
        int count = 0;
        
        while ((passedLogin == false) && (count < 3)) {
            System.out.print("Enter username: ");
            String enteredUser = scan.nextLine();
        
            System.out.print("Enter password: ");
            String enteredPass = scan.nextLine();
            
            if ((enteredUser.equals(username)) && (enteredPass.equals(password)))
                passedLogin = true;
            count ++;
        }
        
        //login system
        while (passedLogin == true) {
            //menu
            System.out.println("\n1.Play/Interact \n2.Instructions \n3.Exit");
            String menuChoice = scan.nextLine();
            if ((menuChoice.equals ("1")) || ((menuChoice.equalsIgnoreCase("play")) || (menuChoice.equalsIgnoreCase("interact")))) {
                System.out.println("Starting...");
            }
            else if ((menuChoice.equals ("2")) || (menuChoice.equalsIgnoreCase("instructions"))) {
                System.out.println("Instructions: ");
            }
            else {
                System.exit(0);
            }
            //select pet
            System.out.println("Choose your pet: ");
        
            System.out.println("Celestial Cat");
            System.out.println("Frosted Hare");
            System.out.println("Ember firefox");
            System.out.println("Phoenix Puppy");
        
            String chosenPet = scan.nextLine();
            System.out.println("You chose the " + chosenPet);
            
            //name generator
            System.out.println("Choose a pet name");
            System.out.println("a) Type a name");
            System.out.println("b) Generate a random name");
            char namingChoice = scan.next().charAt(0);
            
            String petName = "";
            
            if (namingChoice == 'a') {
                System.out.print("What's your pet name? ");
                petName = scan.nextLine();
            }
            else {
                int nameLength = rd.nextInt(4,9);
                String vowels = "aeiou";
                String consonants = "bcdfghjklmnpqrstvwxyz";
                char nameLetter;
                char firstLetter;
                
                //pick whether it starts with a vowel or consonant
                int vowelOrConsonant = rd.nextInt(2);
                if (vowelOrConsonant == 0) {
                    firstLetter = vowels.charAt(rd.nextInt(5));
                }
                else {
                    firstLetter = consonants.charAt(rd.nextInt(26));
                }
                petName += firstLetter;
                
                //pick remaining letters of name 
                for (int i = 1; i < nameLength; i++) {
                    if (vowelOrConsonant == 1) {
                        nameLetter = vowels.charAt(rd.nextInt(5));
                        vowelOrConsonant = 0;
                    }
                    else {
                        nameLetter = consonants.charAt(rd.nextInt(21));
                        vowelOrConsonant = 1;
                            }
                    petName += nameLetter;
                }
            }
            System.out.println("Your pet, named " + petName + ", has been born!");
            
            //pet stats
            int MAX_HEALTH = rd.nextInt((17)+1);
            int MAX_FOOD = rd.nextInt((19-MAX_HEALTH) + 1);
            int MAX_ENERGY = 20 - MAX_HEALTH - MAX_FOOD;
            
            System.out.println("MAXHEALTH: " + MAX_HEALTH + " MAXFOOD: " + MAX_FOOD + " MAX_ENERGY: " + MAX_ENERGY);
            //flush enter key
            scan.nextLine();
            
            //number guessing game
            int randomNum = rd.nextInt(100)+1;
            int guessedNum = 0;
            int numGuesses = 6;
            int points = 0;
            
            while ((numGuesses > 1) && (guessedNum != randomNum)) {
                System.out.print("Guess a number: ");
                guessedNum = scan.nextInt();
                numGuesses--;
                
                if (guessedNum > randomNum) {
                    System.out.println("too high");
                }
                else if (guessedNum < randomNum) {
                    System.out.println("too low");
                }
            }
            if (guessedNum == randomNum) {
                System.out.println("You guessed it!");
                points = numGuesses;
            }
            else {
                System.out.println("You ran out of tries :(");
            }
            System.out.println("Your final score is " + points);
            
            //matching game
        }
        System.out.println("wrong username or password");
        System.exit(0);
    }  
 }
