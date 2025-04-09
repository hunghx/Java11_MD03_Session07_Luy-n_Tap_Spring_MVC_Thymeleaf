package ra.edu.dao;

import ra.edu.entity.Category;

import java.util.List;

public interface ICategoryDao extends IGenericDao<Category,Integer>{
    List<Category> findByPagination(int limit, int offset);
}
