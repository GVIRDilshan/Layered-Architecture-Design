package bo;

import bo.custom.impl.CustomerBOImpl;
import bo.custom.impl.ItemBOImpl;
import bo.custom.impl.OrderBOImpl;
import bo.custom.impl.OrderDetailBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getBoFactory(){
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes{
        CUSTOMER,ITEM,ORDER,ORDER_DETAIL
    }

    public SuperBO getBO(BOTypes types){
        switch (types){
            case CUSTOMER : return new CustomerBOImpl();
            case ITEM: return new ItemBOImpl();
            case ORDER:return new OrderBOImpl();
            case ORDER_DETAIL: return new OrderDetailBOImpl();
            default:return null;
        }
    }
}
