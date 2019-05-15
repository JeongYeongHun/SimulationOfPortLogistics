package teamproject;

/**
 *
 * @author 정영훈
 */

public interface SaveLoadWay {
    void save(String str);
    String load(String str,int index1,int index2);
    void modifyFile(String oldString, String newString);
}
