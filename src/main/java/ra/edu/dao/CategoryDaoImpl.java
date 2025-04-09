package ra.edu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.edu.entity.Category;
import ra.edu.utils.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDaoImpl implements ICategoryDao{
    @Autowired
    private ConnectionDB connectionDB;
    @Override
    public List<Category> findAll() {
        List<Category> list = new ArrayList<>();
        Connection conn = connectionDB.openConnection();
        try{
            PreparedStatement pre = conn.prepareStatement("SELECT id, name, description, created_at from category");
            ResultSet rs = pre.executeQuery();
            while (rs.next()){
                Category cat = new Category(
                  rs.getInt("id"),
                  rs.getString("name"),
                  rs.getString("description"),
                  rs.getDate("created_at")
                );
                list.add(cat);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            connectionDB.closeConnection(conn);
        }
        return list;
    }

    @Override
    public List<Category> findByPagination(int limit, int offset) {
        List<Category> list = new ArrayList<>();
        Connection conn = connectionDB.openConnection();
        try{
            PreparedStatement pre = conn.prepareStatement("SELECT id, name, description, created_at from category order by created_at desc limit ? offset ?");
            pre.setInt(1,limit);
            pre.setInt(2, offset);
            ResultSet rs = pre.executeQuery();
            while (rs.next()){
                Category cat = new Category(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDate("created_at")
                );
                list.add(cat);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            connectionDB.closeConnection(conn);
        }
        return list;
    }
}
