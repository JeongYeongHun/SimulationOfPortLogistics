package teamproject;

/**
 *
 * @author 정영훈
 */

public class ReleaseVersion extends WBS {

    public ReleaseVersion() {
        saveLoadWay = new UsingDB();
    }
    
    @Override
    public void WayPrint() {
        System.out.println("ReleaseVersion...");
    }
}
