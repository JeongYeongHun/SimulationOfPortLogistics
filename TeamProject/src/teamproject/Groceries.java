package teamproject;

/**
 *
 * @author 이준석, 엄도윤
 */
public class Groceries extends Goods {

    public Groceries() {
        type = "식료품류";
    }
    public void setInfo(String id,  String destination, String registration_date,String location){
       this.id = id;
       this.destination = destination;
       this.registration_date = registration_date;
       this.location = location;
    }
    public String getInfo(){
        return  id+" "+destination+" "+registration_date +" "+ location;
    }
    public double cost() {
        return 3.0;
    }
    
}
