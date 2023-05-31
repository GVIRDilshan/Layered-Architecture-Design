package bo.custom;

import bo.SuperBO;
import model.CustomerDTO;
import model.OrderDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderBO extends SuperBO {
    public ArrayList<OrderDTO> getAllOrders() throws SQLException, ClassNotFoundException;

    public boolean addOrder(OrderDTO dto) throws SQLException, ClassNotFoundException;

    public boolean updateOrder(OrderDTO dto) throws SQLException, ClassNotFoundException;

    public boolean existOrder(String id) throws SQLException, ClassNotFoundException;

    public String generateNewOrderID() throws SQLException, ClassNotFoundException;

    public boolean deleteOrder(String id) throws SQLException, ClassNotFoundException;

    public OrderDTO searchOrder(String id) throws SQLException, ClassNotFoundException;
}
