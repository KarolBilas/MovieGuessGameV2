public class Main {
    public static int tries = 10;
    public static String message = "Guess the movie name! ";

    public static void main(String[] args) throws Exception {
        //initialize game variables
        boolean hasWon = false;
        boolean hasLost = false;


        String guessedLetters = "";

        //pick random title of movie
        String movieTitle = Game.pickMovie();


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
            //if there are no chanes left set defeat and break the loop
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