import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ItemTable extends JPanel {
    static Object columnNames[] = {"ID", "Nazwa", "EAN", "Dostawca", "Sektor", "Iloœæ", "Cena"};
    static JTable table = new JTable();
    JScrollPane scrollPane = new JScrollPane(table);
    JPopupMenu popupMenu = new JPopupMenu();
	
    public static float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
    
    public ItemTable() {
        table.setFillsViewportHeight(true);
        this.add(scrollPane);

        UpdateTable();
    
        JMenuItem changeQuantity = new JMenuItem("Zmiana iloœci");
        changeQuantity.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ev) {
                String amt = JOptionPane.showInputDialog(null,
                        "Ile dodaæ?", 0);
                if (amt != null)
                    ItemsManagement.getInstance().changeQuantity(table.getSelectedRow(), round(Float.valueOf(amt),2));
            }
        });
        popupMenu.add(changeQuantity);
        
        JMenuItem deleteItem = new JMenuItem("Usuñ");
        deleteItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                int i = okcancel("Na pewno chcesz usun¹æ?");
                if(i == 0)
                    ItemsManagement.getInstance().removeSelectedItem(table.getSelectedRow());
            }
        });
        popupMenu.add(deleteItem);
    
    
    table.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseReleased(MouseEvent e) {
            int r = table.rowAtPoint(e.getPoint());
            if (r >= 0 && r < table.getRowCount()) {
                table.setRowSelectionInterval(r, r);
            } else {
                table.clearSelection();
            }

            int rowindex = table.getSelectedRow();
            if (rowindex < 0)
                return;
            if (e.isPopupTrigger() && e.getComponent() instanceof JTable) {
                popupMenu.show(e.getComponent(), e.getX(), e.getY());
            }
        }
    });
}
    
    public static void UpdateTable() {
        DefaultTableModel model = new DefaultTableModel(new Object[0][0], columnNames);
        for (Item item : ItemsManagement.getInstance().getItems()) {
            Object[] o = new Object[7];
            o[0] = item.getID();
            o[1] = item.getName();
            o[2] = item.getEAN();
            o[3] = item.getProvider();
            o[4] = item.getPlace();
            o[5] = item.getQuantity();
            o[6] = item.getPrice();
            model.addRow(o);
        }
        table.setModel(model);
    }

    public static int okcancel(String theMessage) {
        int result = JOptionPane.showConfirmDialog((Component) null, theMessage,
                "Uwaga!", JOptionPane.OK_CANCEL_OPTION);
        return result;
    }
    
}