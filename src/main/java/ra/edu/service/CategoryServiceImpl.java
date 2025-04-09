package ra.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.dao.ICategoryDao;
import ra.edu.entity.Category;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService{
    @Autowired
    private ICategoryDao categoryDao;
    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }
    @Override
    public List<Category> findByPagination(Integer page, Integer size) {
        return categoryDao.findByPagination(size, page*size);
    }

    @Override
    public int countTotalPages(int size) {
        int totalElements = categoryDao.findAll().size(); // tổng sô phần tư
        int mod = totalElements % size; // số dư khi chia
        int even = totalElements / size;
        int totalPages = mod==0?even:even+1;
        return totalPages;
    }
}
