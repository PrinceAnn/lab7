public abstract class Character {
    protected int health;
    protected int strength;
    protected Position pos;
    protected int characterNum;

    
    // Abstract methods that subclasses will implement
    public abstract void takeDamage(int damage);
    public abstract void specialAttack(Position pos,Map map,Character playerKnight,Character playerWitch,Character playerArcher,Character characterThisRound);
    public abstract void move(Command order);
    public void attack(Position pos,Map map,Character playerKnight,Character playerWitch,Character playerArcher,Character characterThisRound) {
    // code for attacking the other character
    int x = pos.getPositionX();
    int y = pos.getPositionY();

    switch(map.map.get(x).get(y)){//坐标为（x,y）的位置
        case 1:playerKnight.takeDamage(characterThisRound.getStrength());break;    //the marker of knight 
        case 2:playerWitch.takeDamage(characterThisRound.getStrength());break;    //the marker of witch 
        case 3:playerArcher.takeDamage(characterThisRound.getStrength());break;   //the marker of archer
    }

    }


    // Getter and setter methods
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }


    public void leftMove(){
        this.pos.subtractPostionY();
    }
    public void rightMove(){
        this.pos.addPositionY();
    }
    public void upMove(){
        this.pos.subtractPostionX();
    }
    public void downMove(){
        this.pos.addPositionX();
    }
}