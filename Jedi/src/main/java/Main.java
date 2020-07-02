import javax.swing.*;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        JFrame window = new JFrame("System zarządzania Jedi");

        window.add(new PanelPierwszy());

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			window.setResizable(false);
        window.setVisible(true);
        window.pack();



    }
}