public class Knight extends Character {
    private int armor = 5;
    private int dieTime = 0;
    private static int characterMarker = 1;
    public Knight(int health, int strength, int armor) {
    this.health = health;
    this.strength = strength;
    this.armor = armor;
    characterNum = 1;
    
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
    public void takeDamage(int damage) {
        damage -= armor;
        this.health -= damage;
        if(this.health <= 0){
            this.health = 0;
            this.dieTime ++;
        }
    }
    public void heal(){
        this.health += 40;
        if(this.health > 100){
            this.health = 100;
        }
    }

    public void revive(){
        if (this.dieTime == 1 && this.health == 0){
            this.health = 50;
        }
    }
   @Override
   public void specialAttack(Position pos, Map map, Character playerKnight, Character playerWitch,
            Character playerArcher, Character characterThisRound) {
        int x = pos.getPositionX();
        int y = pos.getPositionY();
        if((Math.abs(characterThisRound.pos.getPositionX() - pos.getPositionX()) + Math.abs(characterThisRound.pos.getPositionY() - pos.getPositionY())) <= 1){
            switch(map.map.get(x).get(y)){//坐标为（x,y）的位置
                case 1:playerKnight.takeDamage(50);break;    //the marker of knight 
                case 2:playerWitch.takeDamage(50);break;    //the marker of witch 
                case 3:playerArcher.takeDamage(50);break;   //the marker of archer
            }
        }
        this.health -= 20;
        
   }

    public static int getCharacterMarker(){
        return characterMarker;
    }
    }