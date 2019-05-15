package teamproject;

/**
 *
 * @author 이준석, 엄도윤
 */
public class BubbleWraps extends PackingDecorator{

    public BubbleWraps(Goods goods) {
        this.goods = goods;
    }

    @Override
    public String getType() {
        return this.goods.getType();
    }
    

    @Override
    public double cost() {
        return .4 + goods.cost();
    }

    @Override
    public void setInfo(String id, String destination, String registration_date, String locatio) {
        this.id = id;
        this.destination = destination;
        this.registration_date = registration_date;
        this.location = location;
    }

    @Override
    public String getInfo() {
        return this.goods.getInfo();
    }
    
}
