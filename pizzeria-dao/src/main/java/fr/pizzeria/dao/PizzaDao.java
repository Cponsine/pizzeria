package fr.pizzeria.dao;

import java.util.List;
import java.util.Optional;

import fr.pizzeria.Exception.*;
import fr.pizzeria.model.Pizza;

public interface PizzaDao {

	List<Pizza>	findAllPizzas();
//	boolean saveNewPizza(Pizza pizza);
//	boolean updatePizza(String codePizza, Pizza pizza);
//	boolean deletePizza(String codePizza);

	boolean saveNewPizza(Pizza pizza) throws SavePizzaException;
	boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException;
	boolean deletePizza(String codePizza) throws DeletePizzaException;
	public Optional<Pizza> findPizzaByCode(String codePizza);
	
	boolean isCodeExist(String codePizza);
}
