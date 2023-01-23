public class Main {
    public static void main(String[] args) throws Exception {
        //initialize game variables
        boolean hasWon = false;
        boolean hasLost = false;
        int tries = 10;
        String guessedLetters = "";

        //pick random title of movie
        String movieTitle = Game.pickMovie();



        //keep repeating while game not lost and not won
        while (!hasWon && !hasLost) {
            guessedLetters += Game.guessLetter(tries);
            String puzzledTitle = Game.puzzledTitle(movieTitle,guessedLetters);
            System.out.println(puzzledTitle);
        }

    }
}