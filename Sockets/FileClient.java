import java.io.*;
import java.net.*;

public class FileClient {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Change to server IP if needed
        int port = 12345;

        try (Socket socket = new Socket(serverAddress, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            // Check if there are enough arguments for updating
            if (args.length > 1 && "UPDATE".equalsIgnoreCase(args[0])) {
                out.println("UPDATE");
                out.println(args[1]); // Send the update content from command line
                System.out.println(in.readLine()); // Read update response
            } else {
                // Default action: Read the file
                out.println("READ");
                String response;
                while ((response = in.readLine()) != null) {
                    System.out.println(response);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
