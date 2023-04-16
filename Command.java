public class Command {
    char moveCommand;
    Character character;
    
    Command(char moveCommand,Character character){
        this.moveCommand = moveCommand;
        this.character = character;
        
    }

    public void dealWithMove(Map map){
        map.map.get(character.pos.getPositionX()).set(character.pos.getPositionY(), 0);
        //把移动之前的位置变为0
        character.move(this);
        map.map.get(character.pos.getPositionX()).set(character.pos.getPositionY(), character.characterNum);
        //改变地图上坐标为i，j 为不同玩家角色的代号，即使没有移动成功也没什么影响
    }

}
