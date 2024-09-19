import java.io.*;
import java.net.*;

public class FileServer {
    public static void main(String[] args) {
        int port = 12345;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);
            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("Client connected");
                    handleClient(socket);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket socket) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            
            String command = in.readLine();
            if ("READ".equalsIgnoreCase(command)) {
                readFile(out);
            } else if ("UPDATE".equalsIgnoreCase(command)) {
                String content = in.readLine();
                updateFile(content);
                out.println("File updated successfully.");
            } else {
                out.println("Invalid command.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFile(PrintWriter out) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader("file.txt"))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                out.println(line);
            }
        } catch (IOException e) {
            out.println("Error reading file: " + e.getMessage());
        }
    }

    private static void updateFile(String content) {
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter("file.txt", true))) {
            fileWriter.write(content);
            fileWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
