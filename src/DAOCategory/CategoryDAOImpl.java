package DAOCategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import util.CategoryFileUtil;
import model.Category;

public class CategoryDAOImpl extends HashMap<String, String> implements CategoryDAO{
    private CategoryFileUtil cfu = new CategoryFileUtil();
    private List<Category> categories;

    public CategoryDAOImpl() {
        super();
        
        categories = new ArrayList<>(cfu.readFile("D:\\Code\\NetBeansProjects\\BikeStoresManagementSystem\\src\\data\\Category.txt"));
        this.clear();
        for (Category category : categories) {
            this.put(category.getCategory_id(), category.getCategory_name());
        }
    }

    @Override
    public List<Category> getAll() {
        return categories;
    }

    @Override
    public void add() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Do not have access!");
    }

    @Override
    public void search(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Do not have access!");
    }

    @Override
    public void update(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Do not have access!");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}
