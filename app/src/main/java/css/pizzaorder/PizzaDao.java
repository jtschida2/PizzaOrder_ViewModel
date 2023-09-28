package css.pizzaorder;

import androidx.room.*;

import java.util.List;

public interface PizzaDao {

    @Query("DELETE FROM pizza_table")
    void deleteAll();

    @Delete
    void deleteOne(Pizza pizza);

    @Insert
    void addPizza(Pizza pizza);

    @Query("Select * From pizza_table")
    List<Pizza> getAllPizza();
}
