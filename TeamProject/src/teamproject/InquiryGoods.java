package teamproject;

import java.util.Vector;

/**
 *
 * @author 조성우
 */
public interface InquiryGoods {
    void setElements(String id,String dest,String state,String type);
    String loadIDLine(String id);
}