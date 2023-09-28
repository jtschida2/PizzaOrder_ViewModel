package css.pizzaorder;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity
public class Pizza {
    @Ignore
    final Double[] PIZZA_PRICES = {7.99, 9.99, 12.99, 14.99};
    final String[] PIZZA_SIZES = {"Small","Medium","Large","X-Large"};

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String mPizza;

    public Pizza(@NonNull String pizza) {this.mPizza = pizza;}

    public String getPizza(){return this.mPizza;}

    private String topping;
    private Double price;
    private Integer size;        // size of the pizza as an integer -- sizes are 0=Small, 1=Medium, 2=Large, 3=X-large
    private String strSize;      // size of the pizza as a string
    private String description;  // string description of the pizza for display

    /***
     *  Constructor
     * @param topping - this is a string listing all the toppings
     * @param size - thisis the size of the pizza -- sizes are 0=Small, 1=Medium, 2=Large, 3=X-large
     */
    public Pizza(String topping, Integer size) {
        this.topping = topping;
        this.size = size;
        price = PIZZA_PRICES[size];
        strSize = PIZZA_SIZES[size];
        description = strSize + " " + topping + " pizza";
    }

    public Double getPrice() {
        return price;
    }

    public String toString() {
        return description;
    }

}
