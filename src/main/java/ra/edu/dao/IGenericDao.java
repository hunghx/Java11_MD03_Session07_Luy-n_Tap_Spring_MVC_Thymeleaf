package ra.edu.dao;

import java.util.List;

public interface IGenericDao <T,E>{
    List<T> findAll();
}
