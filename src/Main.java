import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JTextField objectName = new JTextField(10); // Largeur de champ 10 caractères
        JTextField objectQuantity = new JTextField(5);
        JButton addButton = new JButton("Add");
        JButton removeButton = new JButton("Delete");
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> inventory = new JList<>(listModel);
        addButton.addActionListener(e -> {
            String name = objectName.getText().trim();
            String quantity = objectQuantity.getText().trim();

            if (!name.isEmpty() && !quantity.isEmpty()) {
                try {
                    int qty = Integer.parseInt(quantity);
                    if (qty > 0) {
                        listModel.addElement(name + " - " + qty);
                        objectName.setText("");
                        objectQuantity.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "La quantité doit être un entier positif.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Veuillez entrer une quantité valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Les champs ne doivent pas être vides.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });

        removeButton.addActionListener(e -> {
            int selectedIndex = inventory.getSelectedIndex();

            if (selectedIndex != -1) {
                listModel.remove(selectedIndex);
            } else {
                JOptionPane.showMessageDialog(null, "Veuillez sélectionner un élément à supprimer.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("Nom:"));
        panel.add(objectName);
        panel.add(new JLabel("Quantité:"));
        panel.add(objectQuantity);
        panel.add(addButton);
        panel.add(removeButton);
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BorderLayout());
        listPanel.add(new JLabel("Inventaire:"), BorderLayout.NORTH);
        listPanel.add(new JScrollPane(inventory), BorderLayout.CENTER);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Inventory");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.NORTH);
        frame.add(listPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
