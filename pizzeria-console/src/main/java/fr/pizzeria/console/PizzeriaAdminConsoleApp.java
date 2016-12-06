package fr.pizzeria.console;

import java.util.ResourceBundle;
import java.util.Scanner;

import javax.print.attribute.standard.PrinterLocation;
import javax.swing.plaf.synth.SynthSpinnerUI;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.dao.PizzaDaoArray;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.ihm.MainMenu;
import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException  {
		
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String daoConfig = bundle.getString("dao.impl");
		PizzaDao daoFactory = (PizzaDao) Class.forName(daoConfig).newInstance();
		
		/*
		Pizza p1 = new Pizza();
		p1.setCode("MAR");
		
		Pizza p2 = new Pizza();
		p2.setCode("MAR");
		
		System.out.println("p1=p2 ? " + p1.equals(p2));
		*/

		IhmUtil utils = new IhmUtil(new Scanner(System.in), daoFactory);
		MainMenu core = new MainMenu(utils);

		core.start();
	}
}
