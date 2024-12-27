import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JTextField itemNameField;
        JTextField itemQuantityField;
        JButton addButton;
        JButton removeButton;
        JList<String> inventoryList;

        JFrame frame = new JFrame();
        frame.setBackground(Color.BLACK);
        frame.setTitle("TP_Java");
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        itemNameField = new JTextField(15);
        itemQuantityField = new JTextField(5);
        addButton = new JButton("Ajouter");
        removeButton = new JButton("Supprimer");
        inventoryList = new JList<>(new DefaultListModel<>());


        JPanel labelPanel = new JPanel(new FlowLayout());
        labelPanel.add(new JLabel("Nom de l'objet :"));
        labelPanel.add(itemNameField);
        labelPanel.add(new JLabel("Quantité :"));
        labelPanel.add(itemQuantityField);
        labelPanel.add(addButton);
        labelPanel.add(removeButton);

        JPanel listPanel = new JPanel(new BorderLayout());
        listPanel.add(new JLabel("Inventaire :"), BorderLayout.NORTH);
        listPanel.add(new JScrollPane(inventoryList), BorderLayout.CENTER);

        frame.setLayout(new BorderLayout());
        frame.add(labelPanel, BorderLayout.NORTH);
        frame.add(listPanel, BorderLayout.CENTER);

        update();
    }
    public static void update() {

    }
}