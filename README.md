# Microservices Java

This repository contains studies, examples, and implementations of microservices using **Spring Boot**, **Spring Cloud**, and other related technologies.

## 🚀 Overview

The goal is to explore key microservices concepts, such as:

- ✅ Service communication with **Feign**
- ✅ Service discovery using **Spring Cloud Netflix Eureka**
- ✅ API Gateway for routing and security
- ✅ Fault tolerance with **Circuit Breaker** and **Resilience4j**
- ✅ Centralized configuration with **Config Server**
- ✅ Load balancing with **Spring Cloud LoadBalancer**

## 🛠 Technologies Used

- **Spring Boot**
- **Spring Cloud**
- **Feign**
- **Netflix Eureka**
- **API Gateway**
- **Resilience4j**
- **Config Server**
- **LoadBalancer**

## 📌 Project Structure

The repository is structured as follows:

```
├── service-registry  # Eureka Server
├── config-server     # Centralized Configuration Server
├── api-gateway      # API Gateway for routing requests
├── service-A        # Example microservice A
├── service-B        # Example microservice B
└── README.md
```

## 🚀 Getting Started

### Prerequisites

Before running the project, ensure you have installed:

- Java 17+
- Maven 3+
- Docker (optional for containerization)

### Running the Services

1. Clone the repository:
   ```sh
   git clone https://github.com/Ivo-jose/microservices-java.git
   cd microservices-java
   ```
2. Start the Config Server:
   ```sh
   cd config-server
   mvn spring-boot:run
   ```
3. Start the Eureka Service Registry:
   ```sh
   cd service-registry
   mvn spring-boot:run
   ```
4. Start the API Gateway:
   ```sh
   cd api-gateway
   mvn spring-boot:run
   ```
5. Run the microservices:
   ```sh
   cd service-A
   mvn spring-boot:run
   ```
   ```sh
   cd service-B
   mvn spring-boot:run
   ```

## 📖 Additional Resources

- [Spring Cloud Documentation](https://spring.io/projects/spring-cloud)
- [Netflix Eureka](https://cloud.spring.io/spring-cloud-netflix/reference/html/)
- [Resilience4j](https://resilience4j.readme.io/docs)

## 📜 License

This project is open-source and available under the [MIT License](LICENSE).

---

Made with ❤️ for learning microservices!

