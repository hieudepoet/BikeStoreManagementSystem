package DAOCategory;

import java.util.List;

import DAO.DAO;
import model.Category;

public interface CategoryDAO extends DAO<Category>{

    @Override
    List<Category> getAll();
}
