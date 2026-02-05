package database;

import model.Clothingitem;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClothingItemDAO {

    public void insertClothingItem(Clothingitem item) {
        String sql = "INSERT INTO \"clothing_item\" (clothing_id, name, price, size) VALUES (?,?,?,?)";
        Connection conn = DatabaseConnection.getConnection();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, item.getItemId());
            stmt.setString(2, item.getName());
            stmt.setInt(3, (int) item.getPrice());
            stmt.setString(4, item.getSize());

            stmt.executeUpdate();
            System.out.println("Clothing item inserted!");
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
        }
    }


    public List<Clothingitem> getAllItems() {
        List<Clothingitem> items = new ArrayList<>();
        String sql = "SELECT * FROM \"clothing_item\"";

        Connection conn = DatabaseConnection.getConnection();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                items.add(new Clothingitem(
                        rs.getInt("clothing_id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("size")
                ));
            }
            rs.close();
            stmt.close();
            } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
        } return items;
    }

    public Clothingitem getItemById(int id) {
        String sql = "SELECT * FROM \"clothing_item\" WHERE clothing_id=?";
        Connection conn = DatabaseConnection.getConnection();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Clothingitem item = new Clothingitem(
                        rs.getInt("clothing_id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("size")
                );
                rs.close();
                stmt.close();
                return item;
            } rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
        } return null;
    }
    public boolean updateItem(int id, String name, int price, String size) {
        String sql = "UPDATE \"clothing_item\" SET name=?,price=?,size=? WHERE clothing_id=?";
        Connection conn = DatabaseConnection.getConnection();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, name);
            stmt.setInt(2, price);
            stmt.setString(3, size);
            stmt.setInt(4, id);

            int rows = stmt.executeUpdate();
            stmt.close();

            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DatabaseConnection.closeConnection(conn);
        }
    }

    public boolean deleteItem(int id) {
        String sql = "DELETE FROM \"clothing_item\" WHERE clothing_id=?";
        Connection conn = DatabaseConnection.getConnection();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            int rows = stmt.executeUpdate();
            stmt.close();

            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
        } return false;
    }

    public List<Clothingitem> searchByName(String name) {
        List<Clothingitem> items = new ArrayList<>();
        String sql = "SELECT * FROM \"clothing_item\" WHERE name ILIKE ?";

        Connection conn = DatabaseConnection.getConnection();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + name + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                items.add(new Clothingitem(
                        rs.getInt("clothing_id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("size")
                ));
            } rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
        } return items;
    }
    public List<Clothingitem> searchByMaxPrice(int maxPrice) {
        List<Clothingitem> items = new ArrayList<>();
        String sql = "SELECT * FROM \"clothing_item\" WHERE price <= ?";

        Connection conn = DatabaseConnection.getConnection();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,maxPrice);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                items.add(new Clothingitem(
                        rs.getInt("clothing_id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("size")
                ));
            }
                rs.close();
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
            DatabaseConnection.closeConnection(conn);
        }
        return items;
    }
}