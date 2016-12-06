package fr.pizzeria.ihm.action;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.dao.*;
import fr.pizzeria.model.*;


public class ListPizzaGpCat extends Action{

	private IhmUtil utils;

	public ListPizzaGpCat(IhmUtil utils) {
		super();
		this.setDescription("5. Lister les pizzas par catégorie");
		this.utils = utils;
	}

	@Override
	public void do_action() {

		
		
		Map<CategoriePizza, List<Pizza>> LiClass = utils.getPizzaDao().findAllPizzas().stream().collect(Collectors.groupingBy(Pizza::getCat));

		System.out.println(LiClass);
	}
	
	@Override
	public void describe_action() {
		System.out.println(this.getDescription());
		
	}

}

	



