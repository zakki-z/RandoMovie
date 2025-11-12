# Randomovie - Movie Management Platform

A full-stack movie management application that allows users to browse movies, manage watchlists, track watched movies, and curate favorite collections.

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Architecture](#architecture)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [Database Schema](#database-schema)
- [Project Structure](#project-structure)
- [Documentation](#documentation)
- [Future Development](#future-development)
- [Contact](#Contact)

## 🎯 Overview

Randomovie is a comprehensive movie management system that provides users with tools to discover, organize, and track their movie-watching journey. The platform features user authentication, personalized movie lists, and random movie discovery capabilities.

## ✨ Features

### User Management
- User registration and authentication
- Secure login/logout functionality
- Profile management

### Movie Operations
- Browse complete movie catalog
- View detailed movie information (title, genre, rating, poster, description, year, duration)
- Get random movie recommendations
- CRUD operations for movie management

### Personal Collections
- **Watchlist**: Save movies to watch later
- **Watched List**: Track movies you've already seen
- **Favorites**: Curate your favorite movies collection
- Add/remove movies from any collection

## 🛠 Technology Stack

### Backend
- **Framework**: Spring Boot 3.5.7
- **Language**: Java 21
- **ORM**: Spring Data JPA / Hibernate
- **Database**: PostgreSQL
- **Build Tool**: Maven
- **Additional Libraries**:
  - Lombok (boilerplate reduction)
  - Jakarta Validation (data validation)
  - Spring Data JDBC

### Database
- PostgreSQL (running on localhost:5432)

## 🏗 Architecture

The application follows a layered architecture pattern:
```
┌─────────────────┐
│   Controllers   │  (REST API Layer)
├─────────────────┤
│    Services     │  (Business Logic)
├─────────────────┤
│  Repositories   │  (Data Access)
├─────────────────┤
│    Database     │  (PostgreSQL)
└─────────────────┘
```

### Design Patterns
- **Repository Pattern**: Data access abstraction
- **Service Layer Pattern**: Business logic separation
- **DTO Pattern**: Data transfer between layers
- **Dependency Injection**: Spring's IoC container

## 🚀 Getting Started

### Prerequisites
- Java 21 or higher
- PostgreSQL 12 or higher
- Maven 3.9.11 or higher

### Installation

1. **Clone the repository**
```bash
   git clone <repository-url>
   cd randomovie
```

2. **Configure Database**
   
   Update `backend/src/main/resources/application.properties`:
```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/randomovie
   spring.datasource.username=your_username
   spring.datasource.password=your_password
```

3. **Create Database**
```sql
   CREATE DATABASE randomovie;
```

4. **Build the Application**
```bash
   cd backend
   ./mvnw clean install
```

5. **Run the Application**
```bash
   ./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`

## 📡 API Endpoints

### Authentication
- `POST /api/auth/register` - Register new user
- `POST /api/auth/login` - User login
- `POST /api/auth/logout` - User logout

### Users
- `GET /api/users` - Get all users
- `GET /api/users/{id}` - Get user by ID
- `POST /api/users` - Create new user
- `PUT /api/users/{id}` - Update user
- `DELETE /api/users/{id}` - Delete user

### Movies
- `GET /api/movies` - Get all movies
- `GET /api/movies/{id}` - Get movie by ID
- `POST /api/movies` - Add new movie
- `PUT /api/movies/{id}` - Update movie
- `DELETE /api/movies/{id}` - Delete movie

### Movie Actions
- `GET /api/movieActions/random` - Get random movie
- `POST /api/movieActions/watchlist` - Add movie to watchlist
- `DELETE /api/movieActions/watchlist` - Remove from watchlist
- `POST /api/movieActions/watchedList` - Add to watched list
- `DELETE /api/movieActions/watchedList` - Remove from watched list
- `POST /api/movieActions/favoriteMovie` - Add to favorites
- `DELETE /api/movieActions/favoriteMovie` - Remove from favorites

## 🗄 Database Schema

### Users Table
- `id` (Primary Key)
- `username` (Not Null)
- `password` (Not Null)

### Movies Table
- `movie_id` (Primary Key)
- `movie_name`
- `movie_genre`
- `movie_rating` (Min: 0.0)
- `movie_poster`
- `movie_description`
- `movie_year` (PositiveOrZero)
- `movie_duration` (Positive)

### Junction Tables
- `user_watchlist` (Many-to-Many: Users ↔ Movies)
- `user_watchedlist` (Many-to-Many: Users ↔ Movies)
- `user_favorite_movies` (Many-to-Many: Users ↔ Movies)

## 📁 Project Structure
```
randomovie/
├── backend/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/backend/
│   │   │   │   ├── controller/         # REST Controllers
│   │   │   │   ├── models/            # Entity Models
│   │   │   │   ├── repository/        # Data Access Layer
│   │   │   │   ├── services/          # Business Logic
│   │   │   │   └── exceptions/        # Custom Exceptions
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   └── test/                      # Unit Tests
│   └── pom.xml
├── diagrams/
│   ├── UseCase.png
│   ├── ClassDiagram.png
│   └── Sequence Diagrams/
│       ├── AdminSeq.pdf
│       ├── AuthenticationSeq.pdf
│       ├── MovieBrowsingSeq.pdf
│       ├── WatchlistSeq.pdf
│       ├── FavoritesSeq.pdf
│       └── Ref*.pdf
└── winDev/                            # Future Mobile Development
```

## 📚 Documentation

Comprehensive system documentation is available in the `diagrams/` directory:

- **Use Case Diagram**: Overall system functionality and user interactions
- **Class Diagram**: System architecture and entity relationships
- **Sequence Diagrams**:
  - Authentication flow
  - Admin operations
  - Movie browsing process
  - Watchlist management
  - Favorites management
  - Additional reference diagrams

## 🔮 Future Development

### Mobile Application (WinDev)
A mobile version of the application is planned using WinDev platform. Development resources are located in the `winDev/` directory.

### Planned Features
- Advanced movie search and filtering
- User ratings and reviews
- Social features (sharing lists, recommendations)
- Movie recommendations based on preferences
- Integration with external movie APIs
- Enhanced authentication (JWT, OAuth)

## 📝 License

This project is currently unlicensed. Please contact the repository owner for usage rights.

## 👨‍💻 Developer

- Developed by zakicodes or Zakariae Azhari.

## 🐛 Known Issues

- Passwords are stored in plain text (security enhancement needed)
- Limited error handling in some endpoints
- No pagination for large datasets

## 📧 Contact

Checkout my github for more projects, you can also checkout my protfolio zakicodes.engineer to know me better

---

**Note**: Remember to update the database credentials in `application.properties` before running the application.
