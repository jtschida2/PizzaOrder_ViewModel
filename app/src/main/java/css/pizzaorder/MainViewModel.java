package css.pizzaorder;

import android.os.Handler;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MainViewModel extends ViewModel {

    PizzaOrder pizzaOrder = new PizzaOrder();
    //PizzaRepository pizzaRepository = new PizzaRepository();

    // For live data updates from https://developer.android.com/topic/libraries/architecture/livedata
    private MutableLiveData<String> orderStatus;
    public MutableLiveData<String> getOrderStatus() {
        if (orderStatus == null) {
            orderStatus = new MutableLiveData<String>();
        }
        return orderStatus;
    }

    public void addToOrder(String topping, int iSize) {
            pizzaOrder.OrderPizza(topping, iSize);
    }

    public void placeOrder() {
        orderStatus.postValue("Order Placed");
        //pizzaOrder.PlaceOrder();
        startPizzaTimer();
    }

    public String getOrder() {
        String orderText = "Pizzas: \n";
        List<String> pizzasOrder = pizzaOrder.getOrder();
        for (String strPizza:pizzasOrder ) {
            orderText = orderText + "\n" + strPizza;
        }
        return orderText;
    }


    /**
     * This class implements a timer for the baking pizza
     */
    private static Runnable pizzaTimer;
    private Handler handler;
    private void startPizzaTimer(){
        handler = new Handler();
        pizzaTimer = new PizzaTimer();
        handler.postDelayed(pizzaTimer, 1000);
    }
    private class PizzaTimer implements Runnable {
        private Integer count = 0;
        @Override
        public void run() {
            count++;
            if (count > 4) {
                orderStatus.postValue("Pizza ready to eat");
            } else if (count > 3) {
                orderStatus.postValue("Pizza is cooling");
                handler.postDelayed(this, 2000);        // cool pizza for 2 seconds
            } else if (count > 2) {
                orderStatus.postValue("Pizza is baking");
                handler.postDelayed(this, 5000);        // bake pizza for 5 seconds
            } else {
                orderStatus.postValue("Pizza is being prepared  ");
                handler.postDelayed(this, 2000);        // wait 2 seconds for pizza to be prepared
            }

        }
    }

}
