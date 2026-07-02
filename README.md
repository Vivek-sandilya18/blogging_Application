# 📝 Blogging Application

A full-stack blogging platform built using **Spring Boot** that allows users to create, manage, publish, and interact with blogs through a clean, responsive, and user-friendly interface.

---

## 🚀 Features

- 🔐 User Registration & Login
- 🛡 Authentication & Authorization
- ✍️ Create New Blogs
- ✏️ Edit Existing Blogs
- 🗑 Delete Blogs
- 📚 View All Published Blogs
- 👤 My Blogs Dashboard
- 👍 Like Blogs
- 👎 Dislike Blogs
- 💬 Add Comments on Blogs
- 📖 View Comments
- ⚡ Real-time Blog Interaction
- 🌐 REST API Integration
- 📱 Responsive User Interface
- 🗄 MySQL Database Connectivity

---

## 🛠 Tech Stack

### Backend
- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- Spring Security
- Maven

### Frontend
- HTML
- CSS
- JavaScript

### Database
- MySQL

---

## 📂 Project Structure

```plaintext
blogging_Application
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── controller
│   │   │   ├── service
│   │   │   ├── repository
│   │   │   ├── model
│   │   │   └── config
│   │   │
│   │   ├── resources
│   │   │   ├── static
│   │   │   ├── templates
│   │   │   └── application.properties
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

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/Vivek-sandilya18/blogging_Application.git
```

### 2️⃣ Navigate to the Project Directory

```bash
cd blogging_Application
```

### 3️⃣ Configure Database

Open:

```plaintext
src/main/resources/application.properties
```

Example configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/blog_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 4️⃣ Run the Application

```bash
mvn spring-boot:run
```

---

## 🌐 Application Workflow

```plaintext
User Registration
        │
        ▼
      Login
        │
        ▼
 Create / Edit Blog
        │
        ▼
 Publish Blog
        │
        ▼
Like • Dislike • Comment
        │
        ▼
 Manage Personal Blogs
```

---

## 📌 Modules

- User Authentication
- Blog Management
- Like & Dislike System
- Comment Management
- User Dashboard
- Responsive Frontend
- REST APIs

---

## 🎯 Future Enhancements

- 🔍 Search Blogs
- 🏷 Categories & Tags
- 🖼 Image Upload
- 👤 User Profile Management
- 📑 Bookmark Blogs
- 🛠 Admin Dashboard
- 📊 Blog Analytics
- 📧 Email Notifications

---

## 🤝 Contributing

Contributions are welcome!

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push the branch
5. Open a Pull Request

---

## ⭐ Support

If you found this project helpful, consider giving it a **⭐ Star** on GitHub.

It helps others discover the project and motivates further development.

---

## 👨‍💻 Author

**Vivek Sharma**

GitHub: https://github.com/Vivek-sandilya18
