package css.pizzaorder;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Pizza.class}, version = 1, exportSchema =false)
public abstract class PizzaDatabase extends RoomDatabase{

    public abstract PizzaDao pizzaDao();

    private static volatile PizzaDatabase INSTANCE;

    private static final int NUMBER_OF_THREADS = 3;

    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static PizzaDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (PizzaDatabase.class){
                if(INSTANCE ==null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    PizzaDatabase.class, "pizza_database")
                                        .build();
                }
            }
        }
        return INSTANCE;
    }
}
