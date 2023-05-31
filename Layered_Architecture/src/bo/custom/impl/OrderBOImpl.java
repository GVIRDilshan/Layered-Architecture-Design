package bo.custom.impl;

import bo.custom.OrderBO;
import dao.DAOFactory;
import dao.custom.OrderDAO;
import dao.custom.impl.OrderDAOImpl;
import model.OrderDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderBOImpl implements OrderBO {
    OrderDAO orderDAO= (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    @Override
    public ArrayList<OrderDTO> getAllOrders() throws SQLException, ClassNotFoundException {
        return orderDAO.getAll();
    }

    @Override
    public boolean addOrder(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return orderDAO.add(dto);
    }

    @Override
    public boolean updateOrder(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return orderDAO.update(dto);
    }

    @Override
    public boolean existOrder(String id) throws SQLException, ClassNotFoundException {
        return orderDAO.exist(id);
    }

    @Override
    public String generateNewOrderID() throws SQLException, ClassNotFoundException {
        return orderDAO.generateNewID();
    }

    @Override
    public boolean deleteOrder(String id) throws SQLException, ClassNotFoundException {
        return orderDAO.delete(id);
    }

    @Override
    public OrderDTO searchOrder(String id) throws SQLException, ClassNotFoundException {
        return orderDAO.search(id);
    }
}
