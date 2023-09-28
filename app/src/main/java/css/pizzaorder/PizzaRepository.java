package css.pizzaorder;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class PizzaRepository {

    private PizzaDao mPizzaDao;
    private List<Pizza> pizzasInOrder;

    PizzaRepository (Application application){
        PizzaDatabase db = PizzaDatabase.getDatabase(application);
        mPizzaDao = db.pizzaDao();
        pizzasInOrder = mPizzaDao.getAllPizza();
    }



}
