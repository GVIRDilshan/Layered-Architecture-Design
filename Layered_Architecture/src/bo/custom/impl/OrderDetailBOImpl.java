package bo.custom.impl;

import bo.custom.OrderDetailBO;
import dao.DAOFactory;
import dao.custom.OrderDetailsDAO;
import dao.custom.impl.OrderDetailsDAOImpl;
import model.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailBOImpl implements OrderDetailBO {
    OrderDetailsDAO orderDAO= (OrderDetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER_DETAILS);

    @Override
    public ArrayList<OrderDetailDTO> getAllOrderDetails() throws SQLException, ClassNotFoundException {
        return orderDAO.getAll();
    }

    @Override
    public boolean addOrderDetail(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
        return orderDAO.add(dto);
    }

    @Override
    public boolean updateOrderDetail(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
        return orderDAO.update(dto);
    }

    @Override
    public boolean existOrderDetail(String id) throws SQLException, ClassNotFoundException {
        return orderDAO.exist(id);
    }

    @Override
    public String generateNewOrderDetailID() throws SQLException, ClassNotFoundException {
        return orderDAO.generateNewID();
    }

    @Override
    public boolean deleteOrderDetail(String id) throws SQLException, ClassNotFoundException {
        return orderDAO.delete(id);
    }

    @Override
    public OrderDetailDTO searchOrderDetail(String id) throws SQLException, ClassNotFoundException {
        return orderDAO.search(id);
    }
}
