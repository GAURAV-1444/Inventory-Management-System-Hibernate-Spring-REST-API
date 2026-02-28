package com.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.Products;
import com.product.repo.ProductRepositry;

@Service
public class ProductServices {
	@Autowired
	private ProductRepositry pr;

	public String addProduct(Products pro) {
		return pr.addProduct(pro);
	}

	public int addMulProducts(List<Products> pros) {
		return pr.addMulProducts(pros);
	}

	public int updateProductById(int id, Products pro) {
		return pr.updateProductById(id, pro);
	}

	public int deleteProductById(int id) {
		return pr.deleteProductById(id);
	}

	public Products getProductById(int id) {
		return pr.getProductById(id);
	}

	public List<Products> getAllProducts() {
		return pr.getAllProducts();
	}

	public List<Products> getProductsByCategory(String category) {
		return pr.getProductsByCategory(category);
	}

	public List<Products> getProductsByName(String name) {
		return pr.getProductsByName(name);
	}

	public List<Products> getProductsPriceGreaterThan(double price) {
		return pr.getProductsPriceGreaterThan(price);
	}

	public List<Products> getProductsPriceLessThan(double price) {
		return pr.getProductsPriceLessThan(price);
	}

	public List<Products> getProductsBetweenPrice(double min, double max) {
		return pr.getProductsBetweenPrice(min, max);
	}

	public List<Products> getProductsOrderByPriceAsc() {
		return pr.getProductsOrderByPriceAsc();
	}

	public List<Products> getProductsOrderByPriceDesc() {
		return pr.getProductsOrderByPriceDesc();
	}

	public List<Products> getProductsWithWarrantyGreaterThan(int months) {
		return pr.getProductsWithWarrantyGreaterThan(months);
	}

	public List<Products> getAvailableProducts() {
		return pr.getAvailableProducts();
	}

	public List<Products> getOutOfStockProducts() {
		return pr.getOutOfStockProducts();
	}

	public List<Products> getProductsManufacturedAfter(String mfgDate) {
		return pr.getProductsManufacturedAfter(mfgDate);
	}

	public List<Products> getProductsExpiringBefore(String expDate) {
		return pr.getProductsExpiringBefore(expDate);
	}

	public List<Products> getProductsByCategoryAndPrice(String category, double price) {
		return pr.getProductsByCategoryAndPrice(category, price);
	}

	public List<Products> searchProductsByName(String keyword) {
		return pr.searchProductsByName(keyword);
	}

	public Long countTotalProducts() {
		return pr.countTotalProducts();
	}

	public List<Products> getMaxPricedProducts() {
		return pr.getMaxPricedProducts();
	}

	public List<Products> getMinPricedProducts() {
		return pr.getMinPricedProducts();
	}

	public Double getAverageProductPrice() {
		return pr.getAverageProductPrice();
	}

	public Long getTotalStockCount() {
		return pr.getTotalStockCount();
	}

	public List<String> getDistinctCategories() {
		return pr.getDistinctCategories();
	}

	public List<Object[]> getProductCountByCategory() {
		return pr.getProductCountByCategory();
	}

	public List<Object[]> getCategoryWiseAveragePrice() {
		return pr.getCategoryWiseAveragePrice();
	}

	public List<Object[]> getWarrantyWiseProductCount() {
		return pr.getWarrantyWiseProductCount();
	}

	public Double getTotalInventoryValue() {
		return pr.getTotalInventoryValue();
	}

	// -------- EXPERT --------

	public List<Products> getHighestStockProducts() {
		return pr.getHighestStockProducts();
	}

	public List<Products> getLowestStockProducts() {
		return pr.getLowestStockProducts();
	}

	public List<Products> getProductsAboveAveragePrice() {
		return pr.getProductsAboveAveragePrice();
	}

	public List<Products> getProductsBelowAveragePrice() {
		return pr.getProductsBelowAveragePrice();
	}

	public List<Products> getProductsWithZeroWarranty() {
		return pr.getProductsWithZeroWarranty();
	}

}
