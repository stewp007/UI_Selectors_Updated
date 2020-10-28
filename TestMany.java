import java.util.LinkedList;
import java.util.List;

/**
 * @author stewartpowell Testing class
 */
public class TestMany {

    /**
     * Used to test the Semantic Controls
     * 
     * @param args unused
     */
    public static void main(String[] args) {

        // Many from N semantic control demo

        /* Values to add to the model */
        List<Object> toppings = new LinkedList<>();
        toppings.add("lettuce");
        toppings.add("tomatoe");
        toppings.add("onion");
        toppings.add("ketchup");
        toppings.add("mustard");
        toppings.add("mayo");

        /* Instantiate the Model and add values */
        MfromN model = new MfromN();
        model.addManyToAllValues(toppings);

        /* Instantiate your choice of view and set titles if applicable */

        DoubleListView doubleView = new DoubleListView(model);
        doubleView.setGroupTitle("Toppings: ");
        doubleView.setChoiceViewName("Selections: ");
        /*
         * FullListView fullView = new FullListView(model, Views.FULL);
         * fullView.setGroupTitle("Toppings: ");
         * fullView.setGroupBackground(SWT.COLOR_DARK_CYAN);
         */
        /* Add view to the model and start the UI */

        model.addView(doubleView);
        // model.addView(fullView);
        System.out.println("Before " + model.getCurrValue());
        model.launchUi();
        System.out.println("After " + model.getCurrValue());

    }

}
