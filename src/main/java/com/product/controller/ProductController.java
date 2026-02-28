package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.Products;
import com.product.services.ProductServices;

@RestController
public class ProductController {
	@Autowired
	private ProductServices ps;

	@PostMapping("/add-product")
	public String addProduct(@RequestBody Products pro) {
		return ps.addProduct(pro);

	}

	@PostMapping("/add-mul-product")
	public int addMulProducts(@RequestBody List<Products> pros) {
		int count = ps.addMulProducts(pros);
		if (count > 0) {
			System.out.println(count + "Products Added to Inventory !!!");
			return count;
		} else {
			System.out.println("Products Insertion field !!!");
			return 0;
		}
	}

	@PutMapping("/update-product/{id}")
	public int updateProductById(@PathVariable int id, @RequestBody Products pro) {
		int row = ps.updateProductById(id, pro);
		if (row > 0) {
			System.out.println(id + " --> Id Product is updated...");
			return id;
		} else {
			System.out.println(id + " --> Id Product is Not updated...");
			return 0;
		}
	}

	@DeleteMapping("/delete-by-id/{id}")
	public int deleteProductById(@PathVariable int id) {
		int row = ps.deleteProductById(id);
		if (row > 0) {
			System.out.println(id + " --> Product Deleted Successfully...");
			return id;
		} else {
			System.out.println(id + " --> Product Not Found...");
			return 0;

		}
	}

	@GetMapping("/get-by-id/{id}")
	public Products getProductById(@PathVariable int id) {
		Products pro = ps.getProductById(id);
		if (pro != null) {
			System.out.println(pro);
			return pro;
		} else {
			System.out.println("Product not found at id -->" + id);
			return null;
		}
	}

	@GetMapping("/get-all-products")
	public List<Products> getAllProducts() {
		for (Products pro : ps.getAllProducts()) {
			System.out.println(pro);
		}
		return ps.getAllProducts();
	}

	@GetMapping("/get-products-by-category/{category}")
	public List<Products> getProductsByCategory(@PathVariable String category) {
		List<Products> pros = ps.getProductsByCategory(category);
		if (pros != null && pros.size() > 0) {
			for (Products prods : pros) {
				System.out.println(prods);
			}
			return pros;
		} else {
			System.out.println("No Products Found for Category --> " + category);
			return null;
		}
	}

	@GetMapping("/get-products-by-name/{name}")
	public List<Products> getProductsByName(@PathVariable String name) {
		List<Products> pros = ps.getProductsByName(name);
		if (pros != null && pros.size() > 0) {
			for (Products prods : pros) {
				System.out.println(prods);
			}
			return pros;
		} else {
			System.out.println("No Products Found of Name--> " + name);
			return null;
		}
	}

	@GetMapping("/get-products-of-greater-price/{price}")
	public List<Products> getProductsPriceGreaterThan(@PathVariable double price) {
		if (price >= 0 && ps.getProductsPriceGreaterThan(price) != null
				&& ps.getProductsPriceGreaterThan(price).size() > 0) {
			for (Products pro : ps.getProductsPriceGreaterThan(price)) {
				System.out.println(pro);
			}
			return ps.getProductsPriceGreaterThan(price);
		} else {
			System.out.println("Products not found for greater than this price !!!");
			return null;
		}
	}

	@GetMapping("/get-products-of-less-price/{price}")
	public List<Products> getProductsPriceLessThan(@PathVariable double price) {
		if (ps.getProductsPriceLessThan(price).size() > 0) {
			for (Products pro : ps.getProductsPriceLessThan(price)) {
				System.out.println(pro);
			}
			return ps.getProductsPriceLessThan(price);
		} else {
			System.out.println("Product not avaliable for below than that price !!!");
			return null;
		}
	}

	@GetMapping("/get-products-in-price-range/{min}/{max}")
	public List<Products> getProductsBetweenPrice(@PathVariable double min, @PathVariable double max) {
		if (ps.getProductsBetweenPrice(min, max).size() > 0 && ps.getProductsBetweenPrice(min, max) != null && min < max
				&& max > 0) {
			for (Products pro : ps.getProductsBetweenPrice(min, max)) {
				System.out.println(pro);
			}
			return ps.getProductsBetweenPrice(min, max);
		} else {
			System.out.println("Product not avaliable for this price range !!!");
			return null;
		}
	}

	@GetMapping("/get-products-by-ascending-order")
	public List<Products> getProductsOrderByPriceAsc() {
		for (Products pro : ps.getProductsOrderByPriceAsc()) {
			System.out.println(pro);
		}
		return ps.getProductsOrderByPriceAsc();
	}

	@GetMapping("/get-products-by-descending-order")
	public List<Products> getProductsOrderByPriceDesc() {
		for (Products pro : ps.getProductsOrderByPriceDesc()) {
			System.out.println(pro);
		}
		return ps.getProductsOrderByPriceDesc();
	}

	@GetMapping("/get-products-with-greater-warranty/{months}")
	public List<Products> getProductsWithWarrantyGreaterThan(@PathVariable int months) {
		if (ps.getProductsWithWarrantyGreaterThan(months).size() > 0) {
			for (Products pro : ps.getProductsWithWarrantyGreaterThan(months)) {
				System.out.println(pro);
			}
			return ps.getProductsWithWarrantyGreaterThan(months);
		} else {
			System.out.println("No Product avaliable for this much Warranty !!! ");
			return null;
		}
	}

	@GetMapping("/get-available-products")
	public List<Products> getAvailableProducts() {
		if (ps.getAvailableProducts().size() > 0) {
			for (Products pro : ps.getAvailableProducts()) {
				System.out.println(pro);
			}

		}
		return ps.getAvailableProducts();
	}

	@GetMapping("/get-out-of-stock-products")
	public List<Products> getOutOfStockProducts() {
		if (ps.getOutOfStockProducts().size() > 0) {
			for (Products pro : ps.getOutOfStockProducts()) {
				System.out.println(pro);
			}
			return ps.getOutOfStockProducts();
		} else {
			System.out.println("All Products Are avaliable in Stock");
			return null;
		}

	}

	@GetMapping("/get-products-manufactured-after/{mfgDate}")
	public List<Products> getProductsManufacturedAfter(@PathVariable String mfgDate) {

		List<Products> products = ps.getProductsManufacturedAfter(mfgDate);

		if (products.isEmpty()) {
			System.out.println("No products available after this manufacturing date");
		} else {
			for (Products pro : products) {
				System.out.println(pro);
			}
		}

		return products;
	}

	@GetMapping("/get-products-expiring-before/{expDate}")
	public List<Products> getProductsExpiringBefore(@PathVariable String expDate) {

		List<Products> products = ps.getProductsExpiringBefore(expDate);

		if (products.isEmpty()) {
			System.out.println("No products available before this Expiring date");
		} else {
			for (Products pro : products) {
				System.out.println(pro);
			}
		}

		return products;
	}

	@GetMapping("/get-products-CategoryAndPrice/{category}/{price}")
	public List<Products> getProductsByCategoryAndPrice(@PathVariable String category, @PathVariable double price) {

		List<Products> products = ps.getProductsByCategoryAndPrice(category, price);

		if (products.isEmpty()) {
			System.out.println("No products available after this manufacturing date");
		} else {
			for (Products pro : products) {
				System.out.println(pro);
			}
		}

		return products;
	}

	@GetMapping("/get-search-products-name-contain-key/{keyword}")
	public List<Products> searchProductsByName(@PathVariable String keyword) {

		List<Products> products = ps.searchProductsByName(keyword);

		if (products.isEmpty()) {
			System.out.println("No products available for this name");
		} else {
			for (Products pro : products) {
				System.out.println(pro);
			}
		}

		return products;
	}

	@GetMapping("/get-total-products-count")
	public Long countTotalProducts() {
		Long count = ps.countTotalProducts();
		System.out.println("Total Products in Inventory: " + count);
		return count;
	}

	@GetMapping("/get-max-priced-products")
	public List<Products> getMaxPricedProducts() {
		List<Products> products = ps.getMaxPricedProducts();
		for (Products p : products) {
			System.out.println(p);
		}
		return products;
	}

	@GetMapping("/get-min-priced-products")
	public List<Products> getMinPricedProducts() {
		List<Products> products = ps.getMinPricedProducts();
		for (Products p : products) {
			System.out.println(p);
		}
		return products;
	}

	@GetMapping("/get-avg-priced-products")
	public Double getAverageProductPrice() {
		Double avg = ps.getAverageProductPrice();
		System.out.println("Average Product Price: " + avg);
		return avg;
	}

	@GetMapping("/get-total-stock-count")
	public Long getTotalStockCount() {
		Long stock = ps.getTotalStockCount();
		System.out.println("Total Stock Quantity: " + stock);
		return stock;
	}

	@GetMapping("/get-categories")
	public List<String> getDistinctCategories() {
		List<String> categories = ps.getDistinctCategories();
		for (String c : categories) {
			System.out.println(c);
		}
		return categories;
	}

	@GetMapping("/get-product-count-by-category")
	public List<Object[]> getProductCountByCategory() {
		List<Object[]> data = ps.getProductCountByCategory();
		for (Object[] row : data) {
			System.out.println("Category: " + row[0] + ", Count: " + row[1]);
		}
		return data;
	}

	@GetMapping("/get-category-wise-average-price")
	public List<Object[]> getCategoryWiseAveragePrice() {
		List<Object[]> data = ps.getCategoryWiseAveragePrice();
		for (Object[] row : data) {
			System.out.println("Category: " + row[0] + ", Avg Price: " + row[1]);
		}
		return data;
	}

	@GetMapping("/get-warranty-wise-average-price")
	public List<Object[]> getWarrantyWiseProductCount() {
		List<Object[]> data = ps.getWarrantyWiseProductCount();
		for (Object[] row : data) {
			System.out.println("Warranty: " + row[0] + " months, Count: " + row[1]);
		}
		return data;
	}

	@GetMapping("/get-total-inventory-value")
	public Double getTotalInventoryValue() {
		Double value = ps.getTotalInventoryValue();
		System.out.println("Total Inventory Value: " + value);
		return value;
	}

	@GetMapping("/get-highest-stock-products")
	public List<Products> getHighestStockProducts() {
		List<Products> products = ps.getHighestStockProducts();
		for (Products p : products) {
			System.out.println(p);
		}
		return products;
	}

	@GetMapping("/get-lowest-stock-products")
	public List<Products> getLowestStockProducts() {
		List<Products> products = ps.getLowestStockProducts();
		for (Products p : products) {
			System.out.println(p);
		}
		return products;
	}

	@GetMapping("/get-product-above-average-price")
	public List<Products> getProductsAboveAveragePrice() {
		List<Products> products = ps.getProductsAboveAveragePrice();
		for (Products p : products) {
			System.out.println(p);
		}
		return products;
	}

	@GetMapping("/get-product-below-average-price")
	public List<Products> getProductsBelowAveragePrice() {
		List<Products> products = ps.getProductsBelowAveragePrice();
		for (Products p : products) {
			System.out.println(p);
		}
		return products;
	}

	@GetMapping("/get-products-with-zero-warranty")
	public List<Products> getProductsWithZeroWarranty() {
		List<Products> products = ps.getProductsWithZeroWarranty();
		for (Products p : products) {
			System.out.println(p);
		}
		return products;
	}

}
