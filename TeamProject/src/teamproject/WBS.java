package teamproject;

/**
 *
 * @author 정영훈
 */

public abstract class WBS {
    protected SaveLoadWay saveLoadWay;
    
    public void save(String str){
        saveLoadWay.save(str);
    }
    
    public String load(String str, int index1,int index2){
        return saveLoadWay.load(str,index1,index2);
    }
    public void modifyFile(String oldString, String newString){
        saveLoadWay.modifyFile(oldString, newString);
    }
    
    public abstract void WayPrint() ;
}