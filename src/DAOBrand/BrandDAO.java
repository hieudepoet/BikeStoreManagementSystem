package DAOBrand;

import java.util.List;

import DAO.DAO;
import model.Brand;

public interface BrandDAO extends DAO<Brand>{

    @Override
    List<Brand> getAll();
    
    @Override
    void add();
}
