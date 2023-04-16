public class Main{
    public static void main(String[] args){
        IO game = new IO();
        game.startGame();
        game.map.printMap();
        game.printResult();
    }
}