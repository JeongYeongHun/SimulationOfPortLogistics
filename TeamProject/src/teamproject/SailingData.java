package teamproject;
import java.util.LinkedList;
import java.util.Vector;

/**
 *
 * @author 엄도윤
 */
public class SailingData extends Subject {

    
    private Object obj;
    private String dest;
    private String date;

    public SailingData() {
        observers = new LinkedList<>();
        vec = new Vector();
    }
    
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if(i>=0){
            observers.remove(i);
        }
    }

    public void notifyObservers() {
        observers.forEach((observer)->{
            observer.update(obj,dest,date);
        });
    }
    
    public void DeliveryStateInfoChanged(){
        notifyObservers();
    }
    
    public void setDeliveryStateInfo(Object obj, String dest, String date){ 
        this.obj = obj;
        this.dest = dest;
        this.date = date;
        DeliveryStateInfoChanged();
    }
  
}