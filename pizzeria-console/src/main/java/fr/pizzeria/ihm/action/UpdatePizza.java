package fr.pizzeria.ihm.action;

import java.util.Optional;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class UpdatePizza extends Action {

	// private IhmUtil utils;
	private Scanner reader;
	private PizzaDao pizzaDao;

	public UpdatePizza(IhmUtil utils) {
		super();
		this.setDescription("3. Mettre à jour une pizza");
		this.reader = utils.getScanner();
		this.pizzaDao = utils.getPizzaDao();
	}

	private void printPizzaList() {

		for (Pizza p: pizzaDao.findAllPizzas()) {
			System.out.println(p.getCode() + " - " + p.getNom() + " (" + p.getPrix() + " €)");
		}
		System.out.println("Veuillez choisir la pizza à modifier.");
		System.out.println("(99 pour abandonner).");
	}

	@Override
	public void do_action() {

		while (true) {
			printPizzaList();

			String code = reader.next();
			Optional<Pizza> optPizza = pizzaDao.findPizzaByCode(code);
			if (optPizza.isPresent()) {
				Pizza pizza = optPizza.get();
				System.out.println("Veuillez saisir le code");
				String newCode = reader.next();
				pizza.setCode(newCode);

				System.out.println("Veuillez saisir le nom (sans espace)");
				String name = reader.next();
				pizza.setNom(name);

				System.out.println("Veuillez saisir le prix");
				String price = reader.next();
				
				System.out.println("Veuillez saisir la catégorie");
				String cat = reader.next();
				
				try {
					pizza.setPrix(Double.parseDouble(price));
				} catch (Exception e) {
					System.out.println("Invalid price");
				}
				break;
				
				
			}
			else if (code.equals("99")) {
				break;
			}
		}
	}

	@Override
	public void describe_action() {
		System.out.println(this.getDescription());
	}

}
