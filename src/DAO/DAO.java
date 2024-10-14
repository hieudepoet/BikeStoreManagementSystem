package DAO;

import java.util.List;

public interface DAO<T> {
    void add();
    void search(String name);
    void update(String id);
    void delete(String id);
    List<T> getAll(); 
}
