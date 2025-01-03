package serviceImpl;

import java.util.List;

import dao.CategoryDAO;
import daoImpl.CategoryDAOImpl;
import models.Category;
import service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	
	CategoryDAO categoryDAO = new CategoryDAOImpl();
		
	@Override
	public void addCategory(Category category) {
		categoryDAO.addCategory(category);
	}

	@Override
	public void updateCategory(Category category) {
		categoryDAO.updateCategory(category);
	}

	@Override
	public void deleteCategory(String categoryId) {
		categoryDAO.deleteCategory(categoryId);
	}

	@Override
	public Category getCategoryById(String categoryId) {
		return categoryDAO.getCategoryById(categoryId);
	}

	@Override
	public int countCategories() {
		return categoryDAO.countCategories();
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryDAO.getAllCategories();
	}

	@Override
	public List<String> getAllCategoryIds() {
		// TODO Auto-generated method stub
		return categoryDAO.getAllCategoryIds();
	}

	@Override
	public List<Category> searchCategory(String searchQuery) {
		// TODO Auto-generated method stub
		return categoryDAO.searchCategory(searchQuery);
	}

}
