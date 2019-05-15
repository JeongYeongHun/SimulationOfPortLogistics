package teamproject;

/**
 *
 * @author 엄도윤
 */
public class Tracer implements Observer{
    private String dest;
    private String date;
    private SailingData sailingData;
    private String id;

    public String getId() {
        return id;
    }

    public Tracer(SailingData sailingData, String id) {
        this.sailingData = sailingData;
        this.sailingData.registerObserver(this);
        this.id = id;
    }

    @Override
    public void update(Object obj, String dest, String date){
        this.dest = dest;
        this.date = date;
        String element = "고유번호 : "+this.id + ", 상태 : "+this.dest +", 처리 날짜 : "+this.date;
        this.sailingData.vec.addElement(element);
    }
}