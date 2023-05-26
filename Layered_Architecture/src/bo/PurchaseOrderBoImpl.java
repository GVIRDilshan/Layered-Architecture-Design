package bo;

import db.DBConnection;
import model.ItemDTO;
import model.OrderDTO;
import model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class PurchaseOrderBoImpl {
    OrderBO orderDAO = new OrderBOImpl();
    ItemBO itemDAO = new ItemBOImpl();
    OrderDetailsBO orderDetailsDAO = new OrderDetailsBOImpl();


    public boolean PurchaseOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails){
        Connection connection = null;
        try {
            connection = DBConnection.getDbConnection().getConnection();

            //Check order id already exist or not

            boolean b1 = orderDAO.existOrder(orderId);
            //*if order id already exist*//*
            if (b1) {
                return false;
            }

            connection.setAutoCommit(false);

            //Save the Order to the order table
            boolean b2 = orderDAO.addOrder(new OrderDTO(orderId, orderDate, customerId));

            if (!b2) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }


            // add data to the Order Details table

            for (OrderDetailDTO detail : orderDetails) {
                boolean b3 = orderDetailsDAO.addOrderDetail(detail);
                if (!b3) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }

                //Search & Update Item
                ItemDTO item = findItem(detail.getItemCode());
                item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

                //update item
                boolean b = itemDAO.updateItem(new ItemDTO(item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand()));

                if (!b) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
            }

            connection.commit();
            connection.setAutoCommit(true);
            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ItemDTO findItem(String code) {
        try {
            return itemDAO.searchItem(code);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find the Item " + code, e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}