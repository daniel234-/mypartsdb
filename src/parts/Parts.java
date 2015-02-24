package parts;

//CS 4743 Assignment 3 by Daniel Gardner

import java.awt.Dimension;

import javax.swing.JFrame;

public class Parts 
{
	public static void main(String[] args) 
	{
		PartGateway pdg = null;
		//try {
		pdg = new PartGatewaySQL();
			
		/*} catch(GatewayException e) {
			System.out.println("Error creating DB connection: " + e.getMessage());
			System.exit(0);
		}*/
		
		Dimension minimumSize = new Dimension(680,960);
		
		PartsModel model = new PartsModel(pdg);
		PartsView view = new PartsView(model);
		InventoryView view2 = new InventoryView(model);
		PartsButtonController controller1 = new PartsButtonController(view, view2, model);
		PartsListController controller2 = new PartsListController(view, model);
		InventoryListController controller3 = new InventoryListController(view2, model);
		PartsUnitPartController controller4 = new PartsUnitPartController(model);
		PartsLocationController controller5 = new PartsLocationController(model);
		view.registerListeners(controller1,controller2,controller4);
		view2.registerListeners(controller1,controller3,controller5);
		
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setSize(680,960);
		view.setMinimumSize(minimumSize);
		view.setResizable(false);
		view.setVisible(true);
		
		view2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view2.setSize(680,960);
		view2.setLocation(690,0);
		view2.setMinimumSize(minimumSize);
		view2.setResizable(false);
		view2.setVisible(true);
	}
}
