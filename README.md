# 📦 Inventory Management System (Hibernate + Spring REST API)

## 🚀 Project Overview

The **Inventory Management System (IMS)** is a backend-focused RESTful application developed using **Spring Framework** and **Hibernate ORM**.
The project demonstrates a complete layered architecture for managing inventory operations such as product creation, updates, stock tracking, filtering, and analytical queries.

This system exposes multiple REST APIs to perform real-world inventory management tasks including CRUD operations, category-based search, price filtering, stock monitoring, and inventory analytics.

---

## 🎯 Key Features

* ✅ Product CRUD Operations (Create, Read, Update, Delete)
* ✅ Bulk Product Insertion
* ✅ Category & Name-based Search
* ✅ Price Filtering & Range Queries
* ✅ Stock Availability Management
* ✅ Warranty-based Filtering
* ✅ Manufacturing & Expiry Date Queries
* ✅ Sorting (Ascending & Descending)
* ✅ Inventory Analytics APIs
* ✅ Aggregate Operations (Count, Avg, Min, Max, Sum)
* ✅ Category-wise Statistics
* ✅ RESTful API Design

---

## 🏗️ Architecture

This project follows a **Layered Architecture**:

```
Controller  →  Service  →  Repository  →  Hibernate  →  MySQL Database
```

### Layers

* **Controller Layer**

  * Handles REST API requests & responses.
* **Service Layer**

  * Contains business logic.
* **Repository Layer**

  * Performs database operations using Hibernate Session API.
* **Database**

  * MySQL used for persistent storage.

---

## 🛠️ Tech Stack

| Technology           | Usage                 |
| -------------------- | --------------------- |
| Java                 | Core Programming      |
| Spring Boot          | Application Framework |
| Hibernate (Pure ORM) | Database ORM          |
| MySQL                | Database              |
| REST APIs            | Communication Layer   |
| Maven                | Dependency Management |

---

## 📂 Project Structure

```
com.product
│
├── controller
│     └── ProductController.java
│
├── services
│     └── ProductServices.java
│
├── repo
│     └── ProductRepository.java
│
├── entity
│     └── Products.java
│
└── InventoryManagementSystemApplication.java
```

---

## ⚙️ Setup & Installation

### 1️⃣ Clone Repository

```bash
git clone https://github.com/your-username/Inventory-Management-System-Hibernate-Spring.git
```

### 2️⃣ Configure Database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/inventory_db
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

### 3️⃣ Run Application

Run the main class:

```
InventoryManagementSystemApplication.java
```

Server starts at:

```
http://localhost:8080
```

---

## 🔗 Sample API Endpoints

### ➤ Add Product

```
POST /add-product
```

### ➤ Get All Products

```
GET /get-all-products
```

### ➤ Update Product

```
PUT /update-product/{id}
```

### ➤ Delete Product

```
DELETE /delete-by-id/{id}
```

### ➤ Filter Examples

```
GET /get-products-by-category/{category}
GET /get-products-of-greater-price/{price}
GET /get-products-in-price-range/{min}/{max}
```

### ➤ Analytics APIs

```
GET /get-total-products-count
GET /get-avg-priced-products
GET /get-total-inventory-value
GET /get-category-wise-average-price
```

---

## 📊 Learning Outcomes

This project demonstrates practical understanding of:

* Hibernate Session Management
* REST API Development
* Layered Application Design
* Database Query Optimization
* Aggregation & Projection Queries
* Backend System Design


---

## ⭐ Future Enhancements

* Authentication & Authorization
* Swagger API Documentation
* Pagination & Sorting Optimization
* Frontend Integration

---

## 📜 License

This project is developed for learning and academic purposes.
