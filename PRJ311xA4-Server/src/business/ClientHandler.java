//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package business;

import com.entity.Client;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javafx.scene.control.TextArea;

public class ClientHandler implements Runnable {
    private DataInputStream dis;
    private DataOutputStream dos;
    private Socket socket;
    private Client client;
    private TextArea txtContent;

    public Socket getSocket() {
        return this.socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public TextArea getTxtContent() {
        return this.txtContent;
    }

    public void setTxtContent(TextArea txtContent) {
        this.txtContent = txtContent;
    }

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public ClientHandler(Socket socket, Client client) {
        this.socket = socket;
        this.client = client;
    }

    public ClientHandler(Socket socket, Client client, TextArea txtContent) {
        this.socket = socket;
        this.client = client;
        this.txtContent = txtContent;
    }

    public void run() {
        try {
            this.dis = new DataInputStream(this.socket.getInputStream());
            this.dos = new DataOutputStream(this.socket.getOutputStream());

            while(true) {
                String line;
                do {
                    line = this.dis.readUTF();
                } while(line == null);

                this.txtContent.appendText("\n" + this.client.getUsername() + ":" + line);
            }
        } catch (Exception var2) {
            var2.printStackTrace();
        }
    }

    public void send(Object line) throws Exception {
        this.dos.writeUTF(line.toString());
        this.txtContent.appendText("\nMe:" + line);
    }
}
