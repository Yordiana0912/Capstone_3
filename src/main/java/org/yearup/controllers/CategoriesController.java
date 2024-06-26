package org.yearup.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.yearup.data.CategoryDao;
import org.yearup.data.ProductDao;
import org.yearup.models.Category;
import org.yearup.models.Product;

import java.util.List;
@RestController
@RequestMapping("products")
@CrossOrigin
// request mapping - controller class , this control the user is going to be going based on the end
//points -the end-localhost :8080 is the url
// add the annotations to make this a REST controller
// add the annotation to make this controller the endpoint for the following url
    // http://localhost:8080/categories
// add annotation to allow cross site origin requests
public class CategoriesController
{
    private CategoryDao categoryDao;
    private ProductDao productDao;
    // create an Autowired controller to inject the categoryDao and ProductDao
// autowire, shortcut in the long run but more work
// to autowire automatically wire the information or dependece injections
// add the appropriate annotation for a get action
    public List<Category> getAll(){
            try {
                CategoryDao categoryService = null;
                List<Category> categories = categoryService.getAllCategories();
                if (categories.isEmpty()) {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No categories found");
                }
                return categories;
            } catch (Exception ex) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops... our bad.", ex);
            }
        }
        // find and return all categories
    // add the appropriate annotation for a get action
    public Category getById(@PathVariable int id)
    {
        try {
            Category category = category.getCategoryById(id);
            if (category == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
            }
            return category;
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops... our bad.", ex);
        }
    }

    @GetMapping("{categoryId}/products")
    public List<Product> getProductsById(@PathVariable int categoryId)
    {
        // get a list of product by categoryId
        return null;
    }
    // add annotation to call this method for a POST action
    // add annotation to ensure that only an ADMIN can call this function
    public Category addCategory(@RequestBody Category category)
    {
        // insert the category
        return null;
    }

    // add annotation to call this method for a PUT (update) action - the url path must include the categoryId
    // add annotation to ensure that only an ADMIN can call this function
    public void updateCategory(@PathVariable int id, @RequestBody Category category)
    {
        // update the category by id
    }


    // add annotation to call this method for a DELETE action - the url path must include the categoryId
    // add annotation to ensure that only an ADMIN can call this function
    public void deleteCategory(@PathVariable int id)
    {
        // delete the category by id
    }
}
