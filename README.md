# 💡 JMS De-Duplication Config Demo

This repository demonstrates the **message de-duplication feature** of **Apache ActiveMQ Artemis** using two simple Spring Boot applications: a `JmsProducer` and a `JmsConsumer`.

The primary goal is to provide a verifiable setup for testing how **Apache ActiveMQ Artemis** and **Redhat AMQ** handle duplicate messages specifically by utilizing the broker's built-in de-duplication mechanism.

---

## 🏗️ Project Structure

The repository is organized into three main components:

* **`queue-docker/`**: Contains the Docker setup for running a local ActiveMQ Artemis instance.
* **`JmsProducer/`**: A Spring Boot application that simulates sending messages to the queue. It is configured to generate and send messages that *should* be detected as duplicates by the broker.
* **`JmsConsumer/`**: A Spring Boot application that consumes messages from the queue, logging the received content to demonstrate which messages were ultimately delivered after de-duplication.

---

## ⚙️ Prerequisites

Before you begin, ensure you have the following installed on your system:

1.  **Java Development Kit (JDK) 17+**: Required to run the Spring Boot applications.
2.  **Maven**: For building the Spring Boot applications.
3.  **Docker & Docker Compose**: Required to start the local ActiveMQ Artemis broker.

---

## 🚀 Getting Started

Follow these steps to set up and run the de-duplication demo.

### 1. Start the ActiveMQ Artemis Broker

Navigate to the `queue-docker` directory and use Docker Compose to spin up the ActiveMQ Artemis instance.

```bash
cd queue-docker
docker-compose up -d