package teamproject;

/**
 *
 * @author 이준석, 엄도윤
 */
public class Electronics extends Goods {
    
    public Electronics(){
        type = "전자제품";
    }
    public void setInfo(String id, String destination,String registration_date,String location){
       this.id = id;
       this.destination = destination;
       this.registration_date = registration_date;
       this.location = location;
    }
    public String getInfo(){
       return  id+" "+destination+" "+registration_date +" "+ location;
    }
    
    public double cost() {
       return 2.0;
    }

}
