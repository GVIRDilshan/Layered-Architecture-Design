package bo.custom;

import bo.SuperBO;
import model.OrderDTO;
import model.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderDetailBO extends SuperBO {
    public ArrayList<OrderDetailDTO> getAllOrderDetails() throws SQLException, ClassNotFoundException;

    public boolean addOrderDetail(OrderDetailDTO dto) throws SQLException, ClassNotFoundException;

    public boolean updateOrderDetail(OrderDetailDTO dto) throws SQLException, ClassNotFoundException;

    public boolean existOrderDetail(String id) throws SQLException, ClassNotFoundException;

    public String generateNewOrderDetailID() throws SQLException, ClassNotFoundException;

    public boolean deleteOrderDetail(String id) throws SQLException, ClassNotFoundException;

    public OrderDetailDTO searchOrderDetail(String id) throws SQLException, ClassNotFoundException;
}
