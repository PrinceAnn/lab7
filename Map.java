import java.util.ArrayList;

public class Map {
    ArrayList<ArrayList<Integer>> map;
    int mapLengthX,mapLengthY;

    Map(int mapLengthX,int mapLengthY){
        this.mapLengthX = mapLengthX;
        this.mapLengthY = mapLengthY;
        createMap();
    }
    
    private void createMap(){
        this.map = new ArrayList<>();

        for (int i = 0; i < this.mapLengthX; i++){
            ArrayList<Integer> tempRow = new ArrayList<>();
            for (int j = 0; j < this.mapLengthY; j++){
                tempRow.add(0);
            }
            map.add(tempRow);
        }
    }

    public void printMap(){
        for (int i = 0; i < this.mapLengthX; i++){
            ArrayList<Integer> tempRow = new ArrayList<>();
                tempRow = this.map.get(i);
                System.out.println(tempRow.toString());
        }
    }

}
