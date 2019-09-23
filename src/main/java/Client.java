import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {

        InetAddress address = InetAddress.getLocalHost();
        Socket socket = new Socket(address, 8080);

        InputStream inputStream = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(inputStream, "UTF-8");
        BufferedReader br = new BufferedReader(isr);


        OutputStream os = socket.getOutputStream();

        PrintStream ps = new PrintStream(os, true);
        Scanner scanner = new Scanner(System.in);

        while (true) {

            String line = scanner.nextLine();

            ps.println(line);

            String response = br.readLine();

            System.out.println(response);

            if(response.equals("QUIT")) {
                break;
            }
        }


        ps.close();

        socket.close();
    }


}
