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
}
