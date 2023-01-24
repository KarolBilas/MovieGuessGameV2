public class Main {


    public static void main(String[] args) throws Exception {
        //initialize game variables
        boolean hasWon = false;
        boolean hasLost = false;
        int tries = 10;

        String guessedLetters = "";

        //pick random title of movie
        String movieTitle = Game.pickMovie();


        //keep looping while game not lost and not won
        while (!hasWon && !hasLost) {
            //get puzzled title
            String puzzledTitle = Game.puzzledTitle(movieTitle, guessedLetters);
            //check if there are any more letters to uncover
            boolean victoryCheck = Game.victoryCheck(puzzledTitle);
            //if all letters are uncovered set victory and break loop
            if (victoryCheck) {
                hasWon = true;
                break;
            }

            //print game instructions and puzzled title
            System.out.println("Guess the movie name! You have " + tries + " chances remaining");
            System.out.println(puzzledTitle);
            System.out.println("Choose a letter: ");

            //grab letter from input and add it to letter pool
            guessedLetters += Game.guessLetter(tries);


        }
        //if there are no underscores the title has been guessed
        if (hasWon) {
            System.out.println("Congratulations! The movie is: " + movieTitle);
        }

    }
}