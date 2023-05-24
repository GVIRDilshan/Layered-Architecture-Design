package dao;

import db.DBConnection;
import model.ItemDTO;

import java.sql.*;
import java.time.LocalDate;

public class ItemDAOImpl implements ItemDAO{
    public ResultSet getAllItems() throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        Statement stm = connection.createStatement();
//        ResultSet rst = stm.executeQuery("SELECT * FROM Item");
//        return rst;
        return SQLUtil.execute("SELECT * FROM Item");
    }

    public void deleteItem(String code) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Item WHERE code=?");
//        pstm.setString(1, code);
//        pstm.executeUpdate();
        SQLUtil.execute("DELETE FROM Item WHERE code=?",code);
    }

    public void saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)");
//        pstm.setString(1, itemDTO.getCode());
//        pstm.setString(2, itemDTO.getDescription());
//        pstm.setBigDecimal(3, itemDTO.getUnitPrice());
//        pstm.setInt(4, itemDTO.getQtyOnHand());
//        pstm.executeUpdate();
        SQLUtil.execute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",itemDTO);
    }
    public boolean updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
//       try {
//           Connection connection = DBConnection.getDbConnection().getConnection();
//           PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?");
//           pstm.setString(1, itemDTO.getDescription());
//           pstm.setBigDecimal(2, itemDTO.getUnitPrice());
//           pstm.setInt(3, itemDTO.getQtyOnHand());
//           pstm.setString(4, itemDTO.getCode());
//           pstm.executeUpdate();
//           return true;
//       }catch (SQLException throwables) {
//           throwables.printStackTrace();
//           return false;
//       }catch (ClassNotFoundException e) {
//           e.printStackTrace();
//           return false;
        return SQLUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",
                itemDTO.getDescription(),itemDTO.getUnitPrice(),
                itemDTO.getQtyOnHand(),itemDTO.getCode());
    }

    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("SELECT code FROM Item WHERE code=?");
//        pstm.setString(1, code);
//        return pstm.executeQuery().next();
        ResultSet rst = SQLUtil.execute("SELECT code FROM Item WHERE code=?",code);
        return rst.next();
    }

    public ResultSet allItemIds() throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        Statement stm = connection.createStatement();
//        ResultSet rst = stm.executeQuery("SELECT * FROM Item");
//        return rst;
       return SQLUtil.execute("SELECT * FROM Item");
    }

    public ResultSet findItem(String code) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Item WHERE code=?");
//        pstm.setString(1, code);
//        ResultSet rst = pstm.executeQuery();
//        return rst;
       return SQLUtil.execute("SELECT * FROM Item WHERE code=?",code);
    }

    public ResultSet itemCode() throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        ResultSet rst = connection.createStatement().executeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
//        return rst;
        return SQLUtil.execute("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
    }

    public ItemDTO searchItem(String itemCode) throws SQLException, ClassNotFoundException {
//        try {
//            Connection connection = DBConnection.getDbConnection().getConnection();
//            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Item WHERE code=?");
//            pstm.setString(1, itemCode);
//            ResultSet rst = pstm.executeQuery();
//            if(rst.next()) {
//                return new ItemDTO(
//                        rst.getString(1),
//                        rst.getString(2),
//                        rst.getBigDecimal(4),
//                        rst.getInt(3)
//                );
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
        ResultSet rst = SQLUtil.execute("SELECT * FROM Item WHERE code=?",itemCode);
        if(rst.next()) {
                return new ItemDTO(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getBigDecimal(4),
                        rst.getInt(3)
                );
            }
        return null;
    }
}
