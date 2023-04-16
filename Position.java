public class Position{
    private int x,y;

    public Position(int x,int y){
        this.x = x;
        this.y = y;
    }

    public void setPositionX(int x){
        this.x = x;
    }
    public int getPositionX(){
        return this.x;
    }
    public void setPositionY(int y){
        this.y = y;
    }
    public int getPositionY(){
        return this.y;
    }

    public void addPositionX(){
        this.x++;
    }
    public void subtractPostionX(){
        this.x--;
    }
    public void addPositionY(){
        this.y++;
    }
    public void subtractPostionY(){
        this.y--;
    }

}