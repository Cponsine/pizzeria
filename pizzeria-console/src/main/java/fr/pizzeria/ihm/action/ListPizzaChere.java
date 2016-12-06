package fr.pizzeria.ihm.action;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.dao.*;
import fr.pizzeria.model.*;

public class ListPizzaChere extends Action{

	private IhmUtil utils;

	public ListPizzaChere(IhmUtil utils) {
		super();
		this.setDescription("6. Lister LA pizza ");
		this.utils = utils;
	}

	@Override
	public void do_action() {

		
		
		Map<CategoriePizza, List<Pizza>> LiClass = utils.getPizzaDao().findAllPizzas().stream().collect(Collectors.groupingBy(Pizza::getCat));

		System.out.println(LiClass);
		
		// utils.getPizzaDao().findAllPizzas().stream().reduce( Collections.max(utils.getPizzaDao().findAllPizzas().Prix);
		

	}
	
	@Override
	public void describe_action() {
		System.out.println(this.getDescription());
		
	}

}
