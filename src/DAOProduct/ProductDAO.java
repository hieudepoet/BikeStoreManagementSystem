    package DAOProduct;

import java.util.List;
import model.Product;
import DAO.DAO;

public interface ProductDAO extends DAO<Product> {
    @Override
    void add(); // Function1 
    
    @Override
    void search(String name); //  

    @Override
    void update(String id); // Function3

    @Override
    void delete(String id); // Function4

    void saveToFile(); // Function5
    
    @Override
    List<Product> getAll(); // Funtionc6
}
