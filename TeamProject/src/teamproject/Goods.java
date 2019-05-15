package teamproject;

/**
 *
 * @author 이준석, 엄도윤
 */
public abstract class Goods {
    
    protected String type = "Unknown";
    protected String id = "Unknown";
    protected String destination = "Unknown";
    protected String registration_date  = "Unknown";
    protected String location  = "Unknown";
    
    public String getType() {
        return type;
    }
    public abstract void setInfo(String id, String destination, String registration_date,String location);
    public abstract String getInfo();
    
    public abstract double cost();
    
}
