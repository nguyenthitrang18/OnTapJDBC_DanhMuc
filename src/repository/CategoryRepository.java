/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import util.JDBCUtil;
/**
 *
 * @author ADMIN
 */
public class CategoryRepository {
    private PreparedStatement ps;
    private Connection conn;
    private ResultSet rs;

    public CategoryRepository() {
        conn = JDBCUtil.getConnection(); 
    }

   
    public List<Category> getList(){
        try {
            List<Category> lstC = new ArrayList<>();
            String query = "select * from danh_muc";
            ps = conn.prepareStatement(query);
            ps.executeQuery();
            rs = ps.getResultSet();
            while(rs.next()){
                lstC.add(new Category(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
            return lstC;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public boolean insert(Category c){
        try {
            String query = "insert into danh_muc values "
                    + "(?, ?, ?)";
            ps = conn.prepareStatement(query);
            ps.setString(1, c.getTen());
            ps.setString(2, c.getMoTa());
            ps.setInt(3, c.getTrangThai());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        
    }
    
    
    public boolean update(Integer id,Category c){
        try {
            String query = " update danh_muc"
                    + " set ten = ?,"
                    + " mo_ta = ?,"
                    + " trang_thai = ?"
                    + " where id = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, c.getTen());
            ps.setString(2, c.getMoTa());
            ps.setInt(3, c.getTrangThai());
            ps.setInt(4, id);
            
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    
    public boolean delete(Integer id){
        try {
            String query = "delete from danh_muc"
                    + " where id = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
}
