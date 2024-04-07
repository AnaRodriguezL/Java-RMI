# Java Remote Method Invocation (RMI) 🔍

This project provides you with an implementation of RMI in Java, a technology that allows you to communicate between distributed Java processes on different systems 🌐

## 📝 Requirements
- JDK (Java Development Kit) installed on your system ☕
- Basic knowledge of Java and object-oriented programming 📚
- An IDE (Integrated Development Environment) such as Eclipse or IntelliJ IDEA may be helpful but not mandatory 💻

## ⚙️ Configuration
Ensure you have the JDK installed on your system.
Clone or download this repository to your local machine.
Open the project in your preferred IDE.

## 🔧 Usage
This project is divided into three main parts:

- **Remote Interface (RemoteInterface.java)**: This interface defines the methods that can be invoked remotely. Make sure both the client and the server have access to this interface.

- **Server Implementation (RemoteServer.java)**: Here you'll find the implementation of the remote interface. This is where you'll define the operations that can be performed remotely.

- **Client (RemoteClient.java)**: The client is responsible for calling the remote methods provided by the server.

To run the project:

1. Compile the Java files on both the server and the client.
2. Start the RMI registry by executing.
```bash
rmiregistry
```
3. Start the server by executing.
```bash
java RemoteServer
```
4. Run the client by executing.
```bash
java RemoteClient
```

## 📄 License
This project is licensed under the MIT License. Feel free to use and modify it according to your needs.