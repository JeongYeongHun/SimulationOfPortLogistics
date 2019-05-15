package teamproject;

import java.util.List;
import java.util.Vector;

/**
 *
 * @author 엄도윤
 */
public abstract class Subject {
    protected List<Observer> observers;
    public Vector vec;
    
    public abstract void registerObserver(Observer o);
    public abstract void removeObserver(Observer o);
    public abstract void notifyObservers();
    
}