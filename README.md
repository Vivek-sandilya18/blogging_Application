# 📝 Blogging Application

A full-stack blogging platform built using **Spring Boot** that enables users to create, manage, publish, and interact with blogs through a clean and responsive interface.

---

## 🚀 Features

✅ User Registration & Login
✅ Authentication & Authorization
✅ Create New Blogs
✅ Edit Existing Blogs
✅ Delete Blogs
✅ View All Published Blogs
✅ My Blogs Section
✅ Like Blogs 👍
✅ Dislike Blogs 👎
✅ Real-time Blog Interaction
✅ Responsive User Interface
✅ REST API Integration
✅ Database Connectivity

---

## 🛠 Tech Stack

### Backend

* Java
* Spring Boot
* Spring MVC
* Spring Data JPA
* Maven

### Frontend

* HTML
* CSS
* JavaScript

### Database

* MySQL

---

## 📂 Project Structure

```plaintext
blogging_Application
│
├── src
│   ├── main
│   │   ├── java
│   │   ├── resources
│   │
│   └── test
│
├── pom.xml
├── mvnw
├── .gitignore
└── README.md
```

---

## ⚙️ Installation

### Clone Repository

```bash
git clone https://github.com/Vivek-sandilya18/blogging_Application.git
```

### Move into Project

```bash
cd blogging_Application
```

### Run Application

```bash
mvn spring-boot:run
```

---

## 🔧 Configure Database

Open:

```plaintext
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/blog_db
spring.datasource.username=root
spring.datasource.password=your_password
```

---

## 🌐 Application Flow

```plaintext
User Registration
        ↓
Login
        ↓
Create Blog
        ↓
Like / Dislike Blogs
        ↓
Manage Blogs
        ↓
Publish Content
```

---

## 🎯 Future Improvements

* Comments System
* Profile Management
* Search Blogs
* Categories & Tags
* Image Upload
* Admin Dashboard
* Bookmark Feature
* Blog Analytics

---

## ⭐ Support

If you like this project, don't forget to **give it a star ⭐** and contribute to improve it.
