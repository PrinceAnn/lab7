import java.util.ArrayList;

public class Witch extends Character implements RangedAttack{
    private int range;
    private static int characterMarker = 2;
    public Witch(int health, int strength, int range) {
    this.health = health;
    this.strength = strength;
    this.range = range;
    characterNum = 2;
    }



    @Override
    public void move(Command order) {
        switch(order.moveCommand){
            case 'h':leftMove();break;
            case 'l':rightMove();break;
            case 'k':upMove();break;
            case 'j':downMove();break;
        }
    }

    @Override
    public void attack(Position pos, Map map, Character playerKnight, Character playerWitch, Character playerArcher,
            Character characterThisRound) {
        if((Math.abs(characterThisRound.pos.getPositionX() - pos.getPositionX()) + Math.abs(characterThisRound.pos.getPositionY() - pos.getPositionY())) <= this.range)
            super.attack(pos, map, playerKnight, playerWitch, playerArcher, characterThisRound);
       
    }

    @Override
    public void specialAttack(Position pos, Map map, Character playerKnight, Character playerWitch,
            Character playerArcher, Character characterThisRound) {
        int x = pos.getPositionX();
        int y = pos.getPositionY();
        if((Math.abs(characterThisRound.pos.getPositionX() - pos.getPositionX()) + Math.abs(characterThisRound.pos.getPositionY() - pos.getPositionY())) <= 2){
            switch(map.map.get(x).get(y)){//坐标为（x,y）的位置
                case 1:playerKnight.takeDamage(50);break;    //the marker of knight 
                case 2:playerWitch.takeDamage(50);break;    //the marker of witch 
                case 3:playerArcher.takeDamage(50);break;   //the marker of archer
            }
        }
        this.health += 30;
        if(this.health > 40){
            health = 40;
        }
        
    }

    @Override
    public void takeDamage(int damage) {
        this.health -= damage;
        if(this.health < 0){
            this.health = 0;
        }
    }

    @Override
    public void rangedAttack(Position pos, Map map, Character playerKnight, Character playerWitch,
            Character playerArcher, Character characterThisRound) {
        ArrayList<Position> posAround = new ArrayList<>(); //储存目标位置周围距离为d的所有坐标
        for (int i = 0 ; i < map.mapLengthX ; i ++){
            for (int j = 0 ; j < map.mapLengthY ; j ++){
                if ((Math.abs(i) - pos.getPositionX()) + (Math.abs(j) - pos.getPositionY()) <= 1){
                    posAround.add(new Position(i, j));
                }

            }
        }
        if((Math.abs(characterThisRound.pos.getPositionX() - pos.getPositionX()) + Math.abs(characterThisRound.pos.getPositionY() - pos.getPositionY())) <= 3){
            for (Position position : posAround) {
                int x = position.getPositionX();
                int y = position.getPositionY();
                
                switch(map.map.get(x).get(y)){//坐标为（x,y）的位置
                    case 1:playerKnight.takeDamage(30);break;    //the marker of knight 
                    //case 2:playerWitch.takeDamage(20);break;    //the marker of witch 
                    case 3:playerArcher.takeDamage(30);break;   //the marker of archer
                }
            }
        }
        
    }
    public void heal(){
        this.health += 30;
        if(this.health > 40){
            this.health = 40;
        }
    }

    public int getCharacterMarker(){
        return characterMarker;
    }
}
