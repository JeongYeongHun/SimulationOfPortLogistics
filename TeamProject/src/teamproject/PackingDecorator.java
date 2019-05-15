package teamproject;

/**
 *
 * @author 이준석, 엄도윤
 */
public abstract class PackingDecorator extends Goods {
    protected Goods goods;

    @Override
    public abstract String getType();

}
