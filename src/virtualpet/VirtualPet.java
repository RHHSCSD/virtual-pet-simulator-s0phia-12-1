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
    //method to select pet
    public static String choosePet() {
        Scanner scan = new Scanner(System.in);
        //display menu of pets
        System.out.println("Choose your pet: ");
            System.out.println("1 - Celestial Cat");
            System.out.println("2 - Frosted Hare");
            System.out.println("3 - Ember Firefox");
            System.out.println("4 - Phoenix Puppy");
        
            String chosenPet = "";
            
            int choice = scan.nextInt();
            //determine which pet user chose
            switch (choice) {
                case 1: chosenPet = "Celestial Cat"; break;
                case 2: chosenPet = "Frosted Hare"; break;
                case 3: chosenPet = "Ember Firefox"; break;
                case 4: chosenPet = "Phoenix Puppy"; break;
            }
            return chosenPet;
    }
    
    //method to generate a pet name
    public static String generatePetName() {
        Random rd = new Random();
        int nameLength = rd.nextInt(4,9);
        String petName = "";
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
        return petName;
    }

    //method to play with pet
    public static void playWithPet(int currentEnergy, int maxEnergy) {
        System.out.print("Playing with pet...");
        if (currentEnergy < maxEnergy)
            currentEnergy += 2;
    }
    //method to feed pet
    public static void feedPet(int currentFood, int maxFood) {
        System.out.print("Feeding pet...");
        if (currentFood < maxFood)
            currentFood += 2;
    }
    //method to groom pet
    public static void groomPet(int currentHealth, int maxHealth) {
        System.out.print("Grooming pet...");
        if (currentHealth < maxHealth)
            currentHealth += 2;
    }
    //method for number guessing game
    public static int numberGuessingGame() {
        Random rd = new Random();
        Scanner scan = new Scanner(System.in);
        int randomNum = rd.nextInt(100)+1;
            int guessedNum = 0;
            int numGuesses = 6;
            int moonstones = 0;
            System.out.println("\nNumber Guessing Game");
            System.out.println("---------------------");
            while ((numGuesses > 1) && (guessedNum != randomNum)) {
                System.out.print("\nGuess a number: ");
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
                moonstones = numGuesses * 10;
            }
            else {
                System.out.println("You ran out of tries :(");
                System.out.println("The correct answer is " + randomNum);
            }
            return moonstones;
    }
    
    //method to generate a random letter set
    public static String generateLetterSet() {
        Random rd = new Random();
        String letterSet = "";
            for (int i = 0; i < 10; i++) {
                char randomLetter = (char)(rd.nextInt(26)+65);
                letterSet = letterSet + randomLetter + randomLetter;
            }
            //shuffle letters
            String scrambledSet = "";
            final int length = letterSet.length();
            
            int index = 0;
            char currentLetter = (char) (letterSet.charAt(index));
                
            for (int j = 0; j < length; j++) {
                char nextLetter = (char) (letterSet.charAt(j));
                if (j < length - 1)
                    nextLetter = (char) (letterSet.charAt(j+1));
                double swap = Math.random();
                if (swap > 0.5) {
                    scrambledSet += nextLetter;
                }
                else {
                    swap = Math.random();
                    if (swap > 0.5) {
                        scrambledSet += nextLetter;
                        continue;
                    }
                    scrambledSet += currentLetter;
                    currentLetter = nextLetter;
                    }
                }
            return scrambledSet;
    }
    
    //method for matching game
    public static int matchingGame () {
        String scrambledSet = generateLetterSet();
         for (int i = 0; i < scrambledSet.length(); i++) {
                System.out.print("X");
            }
            int moonstonesEarned = 0;
            Scanner scan = new Scanner(System.in);
            
            for (int i = 0; i < 15; i++) {
                System.out.print("\nMatch 2 indexes: ");
                int index1 = scan.nextInt();
                int index2 = scan.nextInt();
                if (scrambledSet.charAt(index1) == scrambledSet.charAt(index2)) {
                    System.out.println("It's a match!");
                    moonstonesEarned += 10;
                    for (int h = 0; h < scrambledSet.length(); h++) {
                        if ((h == index1) || (h == index2)) {
                            System.out.print(scrambledSet.charAt(i));
                            continue;
                        }
                        System.out.print("X");
                        } 
                }
                else {
                    System.out.println("try again");
                    moonstonesEarned -= 2;
                }
            }
            return moonstonesEarned;
    }
    
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
            System.out.println("You chose the " + choosePet());
            
            //name generator
            System.out.println("Choose a pet name");
            System.out.println("a) Type a name");
            System.out.println("b) Generate a random name");
            char namingChoice = scan.next().charAt(0);
            
            String petName = "";
            
            if (namingChoice == 'a') {
                scan.nextLine();
                System.out.print("What's your pet name? ");
                petName = scan.nextLine();
            }
            else {
                petName = generatePetName();
            }
            System.out.println("Your pet, named " + petName + ", has been born!");
            
            //pet stats
            int [] maxStats = new int[3];
            int [] currentStats = new int[3];
            
            //health
            maxStats[0] = rd.nextInt((17)+1);
            currentStats[0] = maxStats[0];
            //food
            maxStats[1] = rd.nextInt((19 - (maxStats[0])) + 1);
            currentStats[1] = maxStats[1];
            //energy
            maxStats[2] = 20 - maxStats[1] - maxStats[2];
            currentStats[2] = maxStats[2];
            
            System.out.println("\nMAXHEALTH: " + maxStats[0] + " MAXFOOD: " + maxStats[1] + " MAX_ENERGY: " + maxStats[2]);
            
            //number guessing game
            int moonstones = 0;
            moonstones += numberGuessingGame();
            System.out.println("You earned " + moonstones + " Moonstones!");
            scan.nextLine();
            
            //matching game
            int moonstonesEarned = matchingGame();
            moonstones += moonstonesEarned;
            System.out.println("\nYou earned " + moonstonesEarned + " Moonstones!");
            System.out.println("Your Moonstones: " + moonstones);
            
        }
        System.out.println("wrong username or password");
        System.exit(0); 
    }
}
