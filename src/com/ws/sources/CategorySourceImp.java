package com.ws.sources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.entities.Category;
import com.entities.OperationResult;
import com.interfaces.services.CategoryService;
import com.supplier.SpringBeanSupplier;

@Path("/category")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CategorySourceImp implements EntitySource<Category>{

	private static final CategoryService categoryService = getCategoryService();
	
	
	@GET
	@Override
	public List<Category> getList() {
		// TODO Auto-generated method stub
		return categoryService.getList();
	}

	
	@GET
	@Path("/{categoryId}")
	@Override
	public Category getBy(@PathParam("categoryId") int categoryId) {
		// TODO Auto-generated method stub
		return categoryService.getBy(categoryId, true);
	}

	
	@POST
	@Override
	public OperationResult save(Category category) {
		// TODO Auto-generated method stub
		try {
			categoryService.save(category);
		}catch (Exception e) { e.printStackTrace(); return new OperationResult(false); }
		return new OperationResult(true);
	}

	
	@Path("/{categoryId}")
	@DELETE
	@Override
	public OperationResult delete(@PathParam("categoryId") int categoryId) {
		// TODO Auto-generated method stub
		try{
			Category category = categoryService.getBy(categoryId);
			categoryService.delete(category);
		}catch (Exception e) { e.printStackTrace(); return new OperationResult(false); }
		return new OperationResult(true);
	}
	
	@PUT
	@Override
	public OperationResult update(Category entity) {
		// TODO Auto-generated method stub
		try {
			categoryService.saveOrUpdate(entity);
		}catch (Exception e) { e.printStackTrace(); return new OperationResult(false); }
		return new OperationResult(true);
	}
	
	@POST
	@Path("/populate")
	public void populate() {
		categoryService.save(new Category("Gençlik"));
		categoryService.save(new Category("Korku"));
		categoryService.save(new Category("Piskolojik"));
		categoryService.save(new Category("Eðitim"));
	}
	
	public static CategoryService getCategoryService() {
		
		return SpringBeanSupplier.supply(CategoryService.class);
	}

}
