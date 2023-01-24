public class Main {
    //initialize game variables
    public static int tries = 10;
    public static String message = "Guess the movie name! ";
    public static String guessedLetters = "";

    public static void main(String[] args) throws Exception {
        boolean hasWon = false;
        boolean hasLost = false;
        String filename = "movies.txt";
        //pick random title of movie
        String movieTitle = Game.pickMovie(filename);

        //keep looping while game not lost and not won
        while (!hasWon && !hasLost) {
            //get puzzled title
            String puzzledTitle = Game.puzzledTitle(movieTitle, guessedLetters);
            //check if there are any more letters to uncover
            boolean victoryCheck = Game.victoryCheck(puzzledTitle);
            //if all letters are uncovered set victory and break the loop
            if (victoryCheck) {
                hasWon = true;
                break;
            }
            //if there are no chances left set defeat and break the loop
            if (tries <= 0) {
                hasLost = true;
                break;
            }
            //print game instructions and puzzled title
            System.out.println(message + "You have " + tries + " chances remaining");
            System.out.println(puzzledTitle);
            System.out.println("Choose a letter: ");
            //grab letter from input and add it to letter pool
            guessedLetters += Game.guessLetter(movieTitle);
        }
        //after breaking the loop check if victory or defeat conditions has been met
        if (hasWon) {
            System.out.println("Congratulations! The movie is: " + movieTitle);
        }
        if (hasLost) {
            System.out.println("Oh no! The movie you should guess is: " + movieTitle);
        }
    }
}