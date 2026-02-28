package com.product.repo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.product.entity.Products;

@Repository
public class ProductRepositry {

	@Autowired
	private SessionFactory sf;

//1.a) Add a new product to the inventory 
	public String addProduct(Products pro) {
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		Integer id = (Integer) s.save(pro);
		tr.commit();
		s.close();
		return pro + " Added on Id --> " + id;

	}

//1.b) Add Multiple new product to the inventory
	public int addMulProducts(List<Products> pros) {
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		int count = 0;
		for (Products pro : pros) {
			s.save(pro);
			count++;
		}
		tr.commit();
		s.close();
		return count;

	}

//2.Update product details using product id
	public int updateProductById(int id, Products pro) {

		Session s = sf.openSession();

		Products exPro = s.get(Products.class, id);

		if (exPro != null) {

			Transaction tr = s.beginTransaction();

			exPro.setName(pro.getName());
			exPro.setCategory(pro.getCategory());
			exPro.setPrice(pro.getPrice());
			exPro.setManufacturingDate(pro.getManufacturingDate());
			exPro.setExpiryDate(pro.getExpiryDate());
			exPro.setWarranty(pro.getWarranty());
			exPro.setQuantity(pro.getQuantity());

			s.save(exPro);
			tr.commit();
			s.close();

			return exPro.getId();

		} else {
			return 0;
		}

	}

//3.Delete a product using product id
	public int deleteProductById(int id) {
		Session s = sf.openSession();
		Products exPro = s.load(Products.class, id);
		if (exPro != null) {
			Transaction tr = s.beginTransaction();
			s.delete(exPro);
			tr.commit();
			s.close();
			return exPro.getId();
		} else {
			return 0;
		}
	}

//4.Fetch a single product by product id
	public Products getProductById(int id) {
		Session s = sf.openSession();
		Products pro = s.get(Products.class, id);
		s.close();
		return pro;

	}

//5.Fetch all products from inventory
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Products> getAllProducts() {
		Session s = sf.openSession();
		List<Products> pros = s.createCriteria(Products.class).list();
		s.close();
		return pros;
	}

//6.Fetch products belonging to a specific category
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Products> getProductsByCategory(String category) {
		Session s = sf.openSession();
		List<Products> pros = s.createCriteria(Products.class).add(Restrictions.eq("category", category)).list();
		s.close();
		return pros;
	}

//7.Fetch products with an exact product name
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Products> getProductsByName(String name) {
		Session s = sf.openSession();
		List<Products> pros = s.createCriteria(Products.class).add(Restrictions.eq("name", name)).list();
		s.close();
		return pros;
	}

//8.Fetch products with price greater than a given value
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Products> getProductsPriceGreaterThan(double price) {
		Session s = sf.openSession();
		List<Products> pros = s.createCriteria(Products.class).add(Restrictions.gt("price", price)).list();
		s.close();
		return pros;
	}

//9.Fetch products with price less than a given value
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Products> getProductsPriceLessThan(double price) {
		Session s = sf.openSession();
		List<Products> pros = s.createCriteria(Products.class).add(Restrictions.lt("price", price)).list();
		s.close();
		return pros;
	}

//10. Fetch products within a given price range
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Products> getProductsBetweenPrice(double min, double max) {
		Session s = sf.openSession();
		List<Products> pros = s.createCriteria(Products.class).add(Restrictions.between("price", min, max)).list();
		s.close();
		return pros;
	}

//11. Fetch all products ordered by price in ascending order
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Products> getProductsOrderByPriceAsc() {
		Session s = sf.openSession();
		List<Products> pros = s.createCriteria(Products.class).addOrder(Order.asc("price")).list();
		s.close();
		return pros;
	}

//12. Fetch all products ordered by price in descending order
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Products> getProductsOrderByPriceDesc() {
		Session s = sf.openSession();
		List<Products> pros = s.createCriteria(Products.class).addOrder(Order.desc("price")).list();
		s.close();
		return pros;
	}

//13. Fetch products with warranty greater than a given number of months 
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Products> getProductsWithWarrantyGreaterThan(int months) {
		Session s = sf.openSession();
		List<Products> pros = s.createCriteria(Products.class).add(Restrictions.gt("warranty", months)).list();
		s.close();
		return pros;
	}

//14. Fetch all available products (products in stock)
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Products> getAvailableProducts() {
		Session s = sf.openSession();
		List<Products> pros = s.createCriteria(Products.class).add(Restrictions.gt("quantity", 0)).list();
		s.close();
		return pros;
	}

//15. Fetch all out-of-stock products 
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Products> getOutOfStockProducts() {
		Session s = sf.openSession();
		List<Products> pros = s.createCriteria(Products.class).add(Restrictions.le("quantity", 0)).list();
		s.close();
		return pros;
	}

//16. Fetch products manufactured after a given date
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Products> getProductsManufacturedAfter(String mfgDate) {
		Session s = sf.openSession();
		List<Products> pros = s.createCriteria(Products.class).add(Restrictions.gt("manufacturingDate", mfgDate))
				.list();
		s.close();
		return pros;
	}

//17.Fetch products expiring before a given date 
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Products> getProductsExpiringBefore(String expDate) {
		Session s = sf.openSession();
		List<Products> pros = s.createCriteria(Products.class).add(Restrictions.le("expiryDate", expDate)).list();
		s.close();
		return pros;
	}

//18.Fetch products by category and price condition 
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Products> getProductsByCategoryAndPrice(String category, double price) {
		Session s = sf.openSession();
		Criteria cr = s.createCriteria(Products.class);
		cr.add(Restrictions.eq("category", category));
		cr.add(Restrictions.le("price", price));
		List<Products> pros = cr.list();
		s.close();
		return pros;
	}

//19.Search products using name keyword 
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Products> searchProductsByName(String keyword) {
		Session s = sf.openSession();
		List<Products> pros = s.createCriteria(Products.class).add(Restrictions.ilike("name", "%" + keyword + "%"))
				.list();
		s.close();
		return pros;
	}

//20.Count total number of products in inventory
	@SuppressWarnings({ "deprecation" })
	public Long countTotalProducts() {
		Session s = sf.openSession();
		long totalProducts = (long) s.createCriteria(Products.class).setProjection(Projections.rowCount())
				.uniqueResult();
		s.close();
		return totalProducts;
	}

//21.Fetch product(s) with the maximum price 
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Products> getMaxPricedProducts() {
		Session s = sf.openSession();
		Double maxPrice = (Double) s.createCriteria(Products.class).setProjection(Projections.max("price"))
				.uniqueResult();
		List<Products> pros = s.createCriteria(Products.class).add(Restrictions.eq("price", maxPrice)).list();
		s.close();
		return pros;
	}

//22.Fetch product(s) with the minimum price
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Products> getMinPricedProducts() {
		Session s = sf.openSession();
		Double maxPrice = (Double) s.createCriteria(Products.class).setProjection(Projections.min("price"))
				.uniqueResult();
		List<Products> pros = s.createCriteria(Products.class).add(Restrictions.eq("price", maxPrice)).list();
		s.close();
		return pros;
	}

//23.Find the average price of all products
	@SuppressWarnings({ "deprecation" })
	public Double getAverageProductPrice() {
		Session s = sf.openSession();
		Double avgPrice = (Double) s.createCriteria(Products.class).setProjection(Projections.avg("price"))
				.uniqueResult();
		s.close();
		return avgPrice;
	}

//24.Find the total quantity of all products in inventory
	@SuppressWarnings({ "deprecation" })
	public Long getTotalStockCount() {
		Session s = sf.openSession();
		long totalStock = (long) s.createCriteria(Products.class).setProjection(Projections.sum("quantity"))
				.uniqueResult();
		s.close();
		return totalStock;
	}

//25.Fetch distinct product categories 
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<String> getDistinctCategories() {
		Session s = sf.openSession();
		List<String> uniqueCategories = s.createCriteria(Products.class)
				.setProjection(Projections.distinct(Projections.property("category"))).list();
		s.close();
		return uniqueCategories;
	}

//26.Fetch product count for each category 
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Object[]> getProductCountByCategory() {
		Session s = sf.openSession();
		List<Object[]> productCountByCategotry = s.createCriteria(Products.class).setProjection(
				Projections.projectionList().add(Projections.groupProperty("category")).add(Projections.rowCount()))
				.list();
		s.close();
		return productCountByCategotry;
	}

//27.Fetch average product price for each category
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Object[]> getCategoryWiseAveragePrice() {
		Session s = sf.openSession();
		List<Object[]> categoryWiseAveragePrice = s.createCriteria(Products.class).setProjection(
				Projections.projectionList().add(Projections.groupProperty("category")).add(Projections.avg("price")))
				.list();
		s.close();
		return categoryWiseAveragePrice;
	}

//28. Fetch product count grouped by warranty period
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Object[]> getWarrantyWiseProductCount() {
		Session s = sf.openSession();
		List<Object[]> warrantyWiseProductCount = s.createCriteria(Products.class).setProjection(
				Projections.projectionList().add(Projections.groupProperty("warranty")).add(Projections.rowCount()))
				.list();
		s.close();
		return warrantyWiseProductCount;
	}

//29.Calculate total inventory value 
	@SuppressWarnings({ "deprecation", "unchecked" })
	public Double getTotalInventoryValue() {
		Session s = sf.openSession();
		List<Products> allProducts = s.createCriteria(Products.class).list();
		s.close();
		Double totalInventoryValue = 0.0;
		for (Products pro : allProducts) {
			totalInventoryValue += pro.getPrice() * pro.getQuantity();
		}
		return totalInventoryValue;
	}

//30.Fetch product(s) having the highest stock quantity 
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Products> getHighestStockProducts() {
		Session s = sf.openSession();
		Integer highestStockProducts = (Integer) s.createCriteria(Products.class)
				.setProjection(Projections.max("quantity")).uniqueResult();
		List<Products> pros = s.createCriteria(Products.class).add(Restrictions.eq("quantity", highestStockProducts))
				.list();
		s.close();
		return pros;
	}

//31.Fetch product(s) having the lowest stock quantity
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Products> getLowestStockProducts() {
		Session s = sf.openSession();
		Integer lowestStockProducts = (Integer) s.createCriteria(Products.class)
				.setProjection(Projections.min("quantity")).uniqueResult();
		List<Products> pros = s.createCriteria(Products.class).add(Restrictions.eq("quantity", lowestStockProducts))
				.list();
		s.close();
		return pros;
	}

//32. Fetch products priced above the average product price
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Products> getProductsAboveAveragePrice() {
		Session s = sf.openSession();
		Double averagePrice = (Double) s.createCriteria(Products.class).setProjection(Projections.avg("price"))
				.uniqueResult();
		List<Products> pros = s.createCriteria(Products.class).add(Restrictions.gt("price", averagePrice)).list();
		s.close();
		return pros;
	}

//33.Fetch products priced below the average product price
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Products> getProductsBelowAveragePrice() {
		Session s = sf.openSession();
		Double averagePrice = (Double) s.createCriteria(Products.class).setProjection(Projections.avg("price"))
				.uniqueResult();
		List<Products> pros = s.createCriteria(Products.class).add(Restrictions.lt("price", averagePrice)).list();
		s.close();
		return pros;
	}

//34.Fetch the most expensive product from each category 
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Products> getProductsWithZeroWarranty() {
		Session s = sf.openSession();
		List<Products> productsWithZeroWarranty = s.createCriteria(Products.class).add(Restrictions.eq("warranty", 0))
				.list();
		s.close();
		return productsWithZeroWarranty;
	}

}
