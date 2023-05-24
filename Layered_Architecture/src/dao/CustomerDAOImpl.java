package dao;

import db.DBConnection;
import model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {

        ArrayList<CustomerDTO> customerDto= new ArrayList<>();

//        Connection connection = DBConnection.getDbConnection().getConnection();
//        Statement stm = connection.createStatement();
//        ResultSet rst = stm.executeQuery("SELECT * FROM Customer");
          ResultSet rst = SQLUtil.execute("SELECT * FROM Customer");

        while(rst.next()){
            CustomerDTO customerDTO = new CustomerDTO(rst.getString("id"),
                    rst.getString("name"),
                    rst.getString("address"));
            customerDto.add(customerDTO);
        }
        return customerDto;
    }

    public Object saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer (id,name, address) VALUES (?,?,?)");
//        pstm.setString(1, customerDTO.getId());
//        pstm.setString(2, customerDTO.getName());
//        pstm.setString(3, customerDTO.getAddress());
//        pstm.executeUpdate();
        return SQLUtil.execute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",CustomerDTO.getId(),CustomerDTO.getName(),CustomerDTO.getAddress());
    }

    public void updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("UPDATE Customer SET name=?, address=? WHERE id=?");
//        pstm.setString(1, customerDTO.getName());
//        pstm.setString(2, customerDTO.getAddress());
//        pstm.setString(3, customerDTO.getId());
//        pstm.executeUpdate();
        SQLUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?",customerDTO.getName(),customerDTO.getAddress(),customerDTO.getId());
    }

    public void deleteCustomer(String id) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Customer WHERE id=?");
//        pstm.setString(1, id);
//        pstm.executeUpdate();
       SQLUtil.execute("DELETE FROM Customer WHERE id=?",id);
    }

    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("SELECT id FROM Customer WHERE id=?");
//        pstm.setString(1, id);
//        return pstm.executeQuery().next();
        ResultSet rst = SQLUtil.execute("SELECT id FROM Customer WHERE id=?",id);
        return rst.next();
    }

    public ResultSet allCustomerIds() throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        Statement stm = connection.createStatement();
//        ResultSet rst = stm.executeQuery("SELECT * FROM Customer");
//        return rst;
        return SQLUtil.execute("SELECT * FROM Customer");
    }

    public ResultSet customerId() throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        ResultSet rst = connection.createStatement().executeQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
//        return rst;
        return SQLUtil.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1");
    }
}
