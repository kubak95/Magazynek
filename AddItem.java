import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class AddItem extends JPanel implements ActionListener {
	   public void actionPerformed(ActionEvent e){
    	   System.out.println("dziala");
    	   Item newItem = new Item(ItemsManagement.getInstance().getLastIDAndIncrement(), NameField.getText(), Long.valueOf(EANField.getText()), ProviderField.getText(), PlaceField.getText(), Float.valueOf(0), Float.valueOf(0));
    	   ItemsManagement.getInstance().addNewItem(newItem);
       }
	JButton AddItemButton = new JButton("Dodaj przedmiot");
	JTextField NameField = new JTextField("");
	JTextField EANField = new JTextField("");
	JTextField ProviderField = new JTextField("");
	JTextField PlaceField = new JTextField("");

	JLabel NameLabel = new JLabel("Nazwa");
	JLabel EANLabel = new JLabel("EAN");
	JLabel ProviderLabel = new JLabel("Dostawca");
	JLabel PlaceLabel = new JLabel("Sektor");
	
	AddItem(){
		
        NameField.setPreferredSize(new Dimension(50, 15));
        EANField.setPreferredSize(new Dimension(50, 15));
        ProviderField.setPreferredSize(new Dimension(50, 15));
        PlaceField.setPreferredSize(new Dimension(50, 15));	
        
        this.add(NameLabel);
        this.add(NameField);
        this.add(EANLabel);
        this.add(EANField);
        this.add(ProviderLabel);
        this.add(ProviderField);
        this.add(PlaceLabel);
        this.add(PlaceField);
        
       AddItemButton.addActionListener(this);
    
        this.add(AddItemButton);
	}

}

