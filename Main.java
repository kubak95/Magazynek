import javax.swing.*;
public class Main {

	public static void main(String[] args) {
	ItemsManagement.getInstance().LoadAllExistingItems();
	JFrame myFrame = new JFrame();
	JPanel panel = new ItemTable();
	myFrame.setSize(600, 600);
	panel.setSize(600, 600);
	
	JTabbedPane tabbedPane = new JTabbedPane();
	tabbedPane.addTab("Lista towarów", panel);
	tabbedPane.addTab("Zarz¹dzanie towarem", new ItemTable());
	tabbedPane.addTab("Dodaj towar", new AddItem());
	
	myFrame.add(tabbedPane);
	myFrame.setVisible(true);
	}

}
