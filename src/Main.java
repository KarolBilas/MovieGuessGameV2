public class Main {
    public static void main(String[] args) throws Exception {
        //pick random title of movie
        String movieTitle = Game.pickMovie();
        boolean hasWon = false;

        //keep repeating while game not lost and not won
        while(!hasWon) {
        String puzzledMovieTitle = Game.printTitlePuzzle(movieTitle);

            System.out.println(puzzledMovieTitle);

        hasWon = true;
        }

    }
}