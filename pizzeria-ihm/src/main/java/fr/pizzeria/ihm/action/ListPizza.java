package fr.pizzeria.ihm.action;

import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.model.Pizza;

public class ListPizza extends Action {

	private IhmUtil utils;

	public ListPizza(IhmUtil utils) {
		super();
		this.setDescription("1. Lister les pizzas");
		this.utils = utils;
	}

	@Override
	public void do_action() {

		for (Pizza p: utils.getPizzaDao().findAllPizzas()) {
			System.out.println(p.toString());
		}
		System.out.println(utils.getPizzaDao().findAllPizzas().size() + " Pizzas");
	}
	
	@Override
	public void describe_action() {
		System.out.println(this.getDescription());
	}

}
