//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package controller;

import business.ClientHandler;
import business.ServerThread;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ChatBoxController {
    @FXML
    private TextArea txtContent;
    @FXML
    private Button btnSend;
    @FXML
    private TextField txtMessage;
    private ClientHandler cs;
    private ServerBoxController server;
    private String username;

    public ChatBoxController() {
    }

    public void setUsername(String username) {
        this.username = username;
        this.cs = (ClientHandler)ServerThread.clients.get(username);
        this.cs.setTxtContent(this.txtContent);
        (new Thread(this.cs)).start();
    }

    public void btnSendActionPerformed(ActionEvent evt) {
        try {
            this.cs.send(this.txtMessage.getText());
        } catch (Exception var3) {
            System.out.println(var3);
        }

    }
}
