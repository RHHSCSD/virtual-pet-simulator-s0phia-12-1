/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package virtualpet;
import java.util.*;
import java.io.*;
/*
 * @author Sophia Guo
 */
public class VirtualPet {
     
    //costs
    final static int ENERGY_COST = 10;
    final static int FOOD_COST = 10;
    final static int HEALTH_COST = 10;
    
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
            firstLetter = consonants.charAt(rd.nextInt(21));
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
    public static void playWithPet(int currentEnergy, int maxEnergy, int moonstones) {
        if (currentEnergy < maxEnergy && moonstones >= ENERGY_COST) {
            currentEnergy++;
            moonstones -= ENERGY_COST;
            System.out.println("You bought a new toy for your pet!");
            System.out.println("You have " + moonstones + " moonstones left.");
        }
        else if (currentEnergy == maxEnergy) {
            System.out.println("Your pet's energy is full.");
        }
        else {
            System.out.println("You dont have enough moonstones, go play a minigame!");
        }
    }
    //method to feed pet
    public static void feedPet(int currentFood, int maxFood, int moonstones) {
        if (currentFood < maxFood && moonstones >= FOOD_COST) {
            currentFood++;
            moonstones -= FOOD_COST;
            System.out.println("You fed your pet!");
            System.out.println("You have " + moonstones + " moonstones left.");
        }
        else if (currentFood == maxFood) {
            System.out.println("Your pet is not hungry.");
        }
        else {
            System.out.println("You dont have enough moonstones, go play a minigame!");
        }
    }
    //method to groom pet
    public static void groomPet(int currentHealth, int maxHealth, int moonstones) {
        if (currentHealth < maxHealth && moonstones >= HEALTH_COST) {
            currentHealth++;
            moonstones -= HEALTH_COST;
            System.out.println("You groomed your pet!");
            System.out.println("You have " + moonstones + " moonstones left.");
        }
        else if (currentHealth == maxHealth) {
            System.out.println("Your pet is healthy.");
        }
        else {
            System.out.println("You dont have enough moonstones, go play a minigame!");
        }
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
            
            System.out.println("\nMatching Game");
            System.out.println("---------------------");
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
        
        //login system
        boolean passedLogin = false;
        int count = 0;
        
        //get user to login
        System.out.print("Enter username: ");
        String enteredUser = scan.nextLine();
        String enteredPass = ""; 
        
        String chosenPet = "";
        String petName = "";
        
        //money
        int moonstones = 0;
        int moonstonesEarned = 0;
     
        //pet stats
        int [] maxStats = new int[3];
        int [] currentStats = new int[3];
            
        File user = new File(enteredUser + ".txt");
        
        //check if user exists already
        if (!user.exists()) {
            System.out.print("You're a new user!");
            System.out.print("Enter password: ");
            enteredPass = scan.nextLine();
            
            //select pet
            chosenPet = choosePet();
            System.out.println("You chose the " + chosenPet);
            
            //name generator
            System.out.println("Choose a pet name");
            System.out.println("a) Type a name");
            System.out.println("b) Generate a random name");
            char namingChoice = scan.next().charAt(0);
            
            if (namingChoice == 'a') {
                scan.nextLine();
                System.out.print("What's your pet name? ");
                petName = scan.nextLine();
            }
            else {
                petName = generatePetName();
            }
            System.out.println("Your pet, named " + petName + ", has been born!");
            
            //health
            maxStats[0] = rd.nextInt((17)+1);
            currentStats[0] = maxStats[0] / 2;
            //food
            maxStats[1] = rd.nextInt((19 - (maxStats[0])) + 1);
            currentStats[1] = maxStats[1] / 2;
            //energy
            maxStats[2] = 20 - maxStats[1] - maxStats[2];
            currentStats[2] = maxStats[2] / 2;
            
            System.out.println("\nMAXHEALTH: " + maxStats[0] + " MAXFOOD: " + maxStats[1] + " MAX_ENERGY: " + maxStats[2]);
            passedLogin = true;  
            
            scan.nextLine();
        //if they do exist, load information
        } else {
            try {
                Scanner input = new Scanner(user);
                String filePassword = input.nextLine();
                chosenPet = input.nextLine();
                petName = input.nextLine();
                //load all stats
                for (int mStats = 0; mStats < maxStats.length; mStats++) {
                    maxStats[mStats] = input.nextInt();
                }
                for (int cStats = 0; cStats < currentStats.length; cStats++) {
                    currentStats[cStats] = input.nextInt();
                }
                moonstones = input.nextInt();
                input.close();
                
                //check that password is correct
                while ((passedLogin == false) && (count < 3)) {
                    System.out.print("Enter password: ");
                    enteredPass = scan.nextLine();
                    if (enteredPass.equals(filePassword)) 
                        passedLogin = true;
                    count++;
                }
                
            }
            catch (IOException e) {
                System.out.println("Login failed.");
                System.exit(0);         
            }
          }     
        //login system
        while (passedLogin == true) {
            //menu
            System.out.println("\n1.Play/Interact \n2.Instructions \n3.Exit");
            String menuChoice = scan.nextLine();
            
            if ((menuChoice.equals ("1")) || ((menuChoice.equalsIgnoreCase("play")) || (menuChoice.equalsIgnoreCase("interact")))) {
                System.out.println("Starting...");
                System.out.println("Would you like the play a minigame to earn moonstones or interact with your pet?");
                
                System.out.println("1) Play");
                System.out.println("2) Interact");
                menuChoice = scan.nextLine();
                
                //let user choose game they want to play
                if ((menuChoice.equalsIgnoreCase("1")) || (menuChoice.equalsIgnoreCase("play"))) {
                    System.out.println("Which game would you like to play?");
                    System.out.println("1) Number Guessing Game");
                    System.out.println("2) Matching Game");
                    int gameChoice = scan.nextInt();
                
                    //number guessing game
                    if (gameChoice == 1) {
                        moonstonesEarned = numberGuessingGame();
                        moonstones += moonstonesEarned;
                        System.out.println("You earned " + moonstonesEarned + " Moonstones!");
                        System.out.println("Your Moonstones: " + moonstones);
                    }
                    //matching game
                    else if (gameChoice == 2) {
                        moonstonesEarned = matchingGame();
                        moonstones += moonstonesEarned;
                        System.out.println("\nYou earned " + moonstonesEarned + " Moonstones!");
                        System.out.println("Your Moonstones: " + moonstones);
                    }
                    else {
                        System.out.println("You did not select either game.");
                        System.exit(0);
                    }
                }
                //if user chooses interact, let them choose how
                else if ((menuChoice.equalsIgnoreCase("2")) || (menuChoice.equalsIgnoreCase("interact"))) {
                    System.out.println("Choose what you want to do: ");
                    System.out.println("1) Play with pet - $10");
                    System.out.println("2) Feed pet - $10");
                    System.out.println("3) Groom pet - $10");
                    
                    String interaction = scan.nextLine();
                    
                    if (interaction.equals("1") || interaction.equalsIgnoreCase("play")) {
                        playWithPet(currentStats[2], maxStats[2], moonstones);
                    }
                    else if(interaction.equals("2") || interaction.equalsIgnoreCase("feed")) {
                        feedPet(currentStats[1], maxStats[1], moonstones);
                    }
                    else if(interaction.equals("3") || interaction.equalsIgnoreCase("health")) {
                        groomPet(currentStats[0], maxStats[0], moonstones);
                    }
                }
            }
            //instructions
            else if ((menuChoice.equals ("2")) || (menuChoice.equalsIgnoreCase("instructions"))) {
                System.out.println("Instructions: ");
                System.out.println("Here in Critterland, have fun playing with your pets and earning the special moonstones! \nRaise your pet and have fun!");
            }
            //quit game and write information to a file
            else if ((menuChoice.equals ("3")) || (menuChoice.equalsIgnoreCase("exit"))) {
                try {
                    PrintWriter write = new PrintWriter(user);
                    write.println(enteredPass);
                    write.println(chosenPet);
                    write.println(petName);
                    for (int mStats = 0; mStats < maxStats.length; mStats++) {
                        write.println(maxStats[mStats]);
                    }
                    for (int cStats = 0; cStats < currentStats.length; cStats++) {
                        write.println(currentStats[cStats]);
                    }
                    write.println(moonstones);
                    write.close();
                }
                catch (IOException e) {
                    System.out.println("Error Occured");
                }
                System.exit(0);
            }
  
        }
    }
}
