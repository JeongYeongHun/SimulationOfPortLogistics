package teamproject;

/**
 *
 * @author 정영훈
 */

public class TestVersion extends WBS {

    public TestVersion() {
        saveLoadWay = new UsingTextFile();
    }
    
    @Override
    public void WayPrint() {
        System.out.println("TestVersion...");
    }
}
