import java.io.File;
import java.util.Scanner;

public class Game {

    static String pickMovie() throws Exception {
        //initialize variables
        File file = new File("movies.txt");
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

    static char guessLetter(int tries) {

        //print game instructions
        System.out.println("Guess the movie name! You have " + tries + " chances remaining");
        System.out.println("Choose a letter: ");

        //grab input and limit it to first letter to prevent spam
        Scanner scanner = new Scanner(System.in);
        char letter = scanner.nextLine().charAt(0);
        return letter;
    }

}
