package teamproject;

import java.util.List;
import java.util.Vector;

/**
 * @author 조성우
 */
public class WBSAdapter implements InquiryGoods {

    private WBS wbs;
    
    public WBSAdapter(WBS wbs) {
        this.wbs = wbs;
    }

    @Override
    public String loadIDLine(String id) {
        String result = "";
        for(int i= 0 ;i<8;i++){
            result += wbs.load(id,0,i) + " ";
        }
        return result;
    }

    @Override
    public void setElements(String id, String dest, String state, String type) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
