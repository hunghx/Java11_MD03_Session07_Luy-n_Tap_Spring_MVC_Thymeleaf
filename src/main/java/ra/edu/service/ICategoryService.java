package ra.edu.service;

import ra.edu.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    List<Category> findByPagination(Integer page, Integer size);
    int countTotalPages(int size);
}
