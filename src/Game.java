import java.io.File;
import java.util.Scanner;
 public class Game {
    static String pickMovie(String filename) throws Exception {
        //initialize variables
        File file = new File(filename);
        Scanner fileScanner = new Scanner(file);
        int fileRows = 0;
        //loop through file to determine number of rows
        while (fileScanner.hasNextLine()) {
            fileScanner.nextLine();
            fileRows++;
        }
        //declare array with size equal to number of file rows
        String[] movieList = new String[fileRows];
        //there must be more elegant way to reset scanner but dont know it yet
        Scanner fileScanner2 = new Scanner(file);
        //put each row into separate cell of the array
        fileRows = 0;
        while (fileScanner2.hasNextLine()) {
            String line = fileScanner2.nextLine();
            movieList[fileRows] = line;
            fileRows++;
        }
        //generate random number with maximum equal to number of rows in file
        double random = Math.random() * fileRows;
        int randomRow = (int) random;
        //get randomly generated movie name from array
        String movieName = movieList[randomRow];
        return movieName;
    }
     static String puzzledTitle(String movieTitle, String guessLetter) {
        //initialize variable and get title length
        String puzzledTitle = "";
        int titleLength = movieTitle.length();
        //loop through letters and convert characters to underscores leaving space unchanged
        for (int i = 0; i < titleLength; i++) {
            if (guessLetter.contains(Character.toString(movieTitle.charAt(i)))) {
                puzzledTitle += movieTitle.charAt(i);
            } else if (movieTitle.charAt(i) != ' ') {
                puzzledTitle += "_";
            } else {
                puzzledTitle += " ";
            }
        }
        return puzzledTitle;
    }
     static char guessLetter(String movieTitle) throws Exception {
        //grab input and limit it to first letter to prevent spam
        char letter = '0';
        try {
            Scanner scanner = new Scanner(System.in);
            letter = scanner.nextLine().charAt(0);
            //check if movie title contains that letter and reduce chances if not
            if (!movieTitle.contains(Character.toString(letter))) {
                //check if wrong letter was used before reducing chances
                if (!Main.guessedLetters.contains(Character.toString(letter))) {
                    Main.tries--;
                    Main.message = "Wrong guess! ";
                } else {
                    Main.message = "You have tried this letter! ";
                }
             } else {
                if (Main.guessedLetters.contains(Character.toString(letter))) {
                    Main.message = "You have tried this letter! ";
                } else {
                    Main.message = "Correct! ";
                }
             }
        } catch (StringIndexOutOfBoundsException e) {
            Main.message = "Letter cannot be empty! ";
        }
        return letter;
    }
     static boolean victoryCheck(String puzzledTitle) {
        //get title and variables
        int titleLength = puzzledTitle.length();
        boolean victoryCheck = false;
        int uncoveredLetters = 0;
        //loop through letters and check if there are any underscores
        for (int i = 0; i < titleLength; i++) {
            if (puzzledTitle.charAt(i) == '_') {
                uncoveredLetters++;
            }
        }
        //if there is no underscores the title has been guessed
        if (uncoveredLetters == 0) {
            victoryCheck = true;
        }
        return victoryCheck;
    }
 }
