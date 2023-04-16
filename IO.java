import java.util.Scanner;

public class IO{
    Scanner input;
    Map map;
    Knight playerKnight;
    Witch playerWitch;
    Archer playerArcher;

    void startGame(){
       this.input = new Scanner(System.in);
       readMapAndCharacterPos();
       while(true){
            String[] oneInputLine = input.nextLine().split(" ");
            if(oneInputLine[0].equals("End")){
                break;
            }
            String characterName = oneInputLine[0];
            Character characterThisRound = null;
            switch(characterName){
                case "Knight":characterThisRound = playerKnight;break;
                case "Witch":characterThisRound = playerWitch;break;
                case "Archer":characterThisRound = playerArcher;break;
            }
            if (java.lang.Character.isLetter(oneInputLine[1].charAt(0))){
                Command moveCommand = new Command(oneInputLine[1].charAt(0),characterThisRound);
                moveCommand.dealWithMove(map);  
            }
            else if(Integer.parseInt(oneInputLine[1]) == 1){
                dealWithAttack(oneInputLine, characterThisRound);
            }
            else if(Integer.parseInt(oneInputLine[1]) == 2){
                dealWithSpecialAttack(oneInputLine, characterThisRound);
            }
            else if(Integer.parseInt(oneInputLine[1]) == 3){
                dealWithRangedAttack(oneInputLine, characterThisRound);
            }
            else if(Integer.parseInt(oneInputLine[1]) == 4){
                dealWithHeal(characterThisRound);
            }
            else if(Integer.parseInt(oneInputLine[1]) == 5){
                if(characterThisRound.characterNum == 1){
                    ((Knight)characterThisRound).revive();
                }
            }


            
        }
    }

    private void dealWithHeal(Character characterThisRound) {
        if(characterThisRound.characterNum == 1){
            ((Knight)characterThisRound).heal();
        }
        else if(characterThisRound.characterNum == 2){
            ((Witch)characterThisRound).heal();
        }
    }

    private void dealWithRangedAttack(String[] oneInputLine, Character characterThisRound) {
        if(characterThisRound.characterNum == 2 || characterThisRound.characterNum == 3){//法师和弓箭手才有此技能
            
            int targetX = Integer.parseInt(oneInputLine[2]);
            int targetY = Integer.parseInt(oneInputLine[3]);
            Position pos = new Position(targetX,targetY);
            if(characterThisRound.characterNum == 3){
                ((Archer)characterThisRound).rangedAttack(pos, map,playerKnight,playerWitch,playerArcher,characterThisRound);
            }
            else{
                ((Witch)characterThisRound).rangedAttack(pos, map,playerKnight,playerWitch,playerArcher,characterThisRound);
            }
        }
    }

    private void dealWithSpecialAttack(String[] oneInputLine, Character characterThisRound) {
        int targetX = Integer.parseInt(oneInputLine[2]);
        int targetY = Integer.parseInt(oneInputLine[3]);
        Position pos = new Position(targetX,targetY);
        characterThisRound.specialAttack(pos, map,playerKnight,playerWitch,playerArcher,characterThisRound);
    }

    private void dealWithAttack(String[] oneInputLine, Character characterThisRound) {
        int targetX = Integer.parseInt(oneInputLine[2]);
        int targetY = Integer.parseInt(oneInputLine[3]);
        Position pos = new Position(targetX,targetY);
        characterThisRound.attack(pos, map,playerKnight,playerWitch,playerArcher,characterThisRound);
    }

    void readMapAndCharacterPos(){
        int mapLengthX = input.nextInt();
        int mapLengthY = input.nextInt();
        this.input.nextLine();//读走换行符
        map = new Map(mapLengthX, mapLengthY);


        for (int i = 0 ; i < 3 ; i ++ ){
            String characterAndPosition = input.nextLine();
            String characterName = characterAndPosition.split(" ")[0];
            int chPosX = Integer.parseInt(characterAndPosition.split(" ")[1]);
            int chPosY = Integer.parseInt(characterAndPosition.split(" ")[2]);
            setPlayerProperties(characterName, chPosX, chPosY);
        }
    }

    private void setPlayerProperties(String characterName, int chPosX, int chPosY) {
        switch(characterName){
            case "Knight":
                this.playerKnight = new Knight(100, 30, 5);
                playerKnight.pos = new Position(chPosX, chPosY);
                this.map.map.get(chPosX).set(chPosY,1);
                break;
            case "Witch":
                this.playerWitch = new Witch(40, 10, 2);
                playerWitch.pos = new Position(chPosX, chPosY);
                this.map.map.get(chPosX).set(chPosY,2);
            break;
            case "Archer":
                this.playerArcher = new Archer(60, 20, 3);
                playerArcher.pos = new Position(chPosX, chPosY);
                this.map.map.get(chPosX).set(chPosY,3);
                break;
        }
    }

    void printResult(){
        System.out.printf("Knight %d %d %d\n", playerKnight.pos.getPositionX(),playerKnight.pos.getPositionY(),playerKnight.getHealth());
        System.out.printf("Witch %d %d %d\n", playerWitch.pos.getPositionX(),playerWitch.pos.getPositionY(),playerWitch.getHealth());
        System.out.printf("Archer %d %d %d\n", playerArcher.pos.getPositionX(),playerArcher.pos.getPositionY(),playerArcher.getHealth());
    }



}
