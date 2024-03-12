package com.ejada.demo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="basicView")
@ViewScoped
public class BasicView implements Serializable {

    private List<Product> products;
    

    public BasicView() {
    	products = new ArrayList<Product>();
    	products.add(new Product(1L,"x", "y"));
    	products.add(new Product(2L,"a", "b"));
    	products.add(new Product(3L,"c", "d"));

    }

    public List<Product> getProducts() {
        return products;
    }
    public void delete(Product p) {
    	products.remove(p);
    }
}

