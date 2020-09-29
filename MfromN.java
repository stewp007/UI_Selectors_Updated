import java.util.LinkedList;
import java.util.List;

/**
 * 
 */

/**
 * @author stewartpowell
 *
 */
public class MfromN {

    /** The set of all possible values */
    private List<Object> allValues;
    /** The set of chosen values */
    private List<Object> currValues;
    /** The array of Instantiated Views for this Model */
    private List<UiView> views;

    /**
     * Constructor for MfromN Model
     */
    public MfromN() {
        this.allValues = new LinkedList<>();
        this.currValues = new LinkedList<>();
        this.views = new LinkedList<>();
    }

    /**
     * Adds a value to the current list of values
     * 
     * @param value a value to add to the current Values
     */
    public void addValue(Object value) {
        currValues.add(value);
    }

    /**
     * Adds a list of values to the current list of values
     * 
     * @param value a value to add to the current Values
     */
    public void addValue(List<Object> value) {
        currValues.addAll(value);
    }

    /**
     * Adds a view to the current list of views
     * 
     * @param view a value to add to the current Values
     */
    public void addView(MfromNViews view) {
        switch (view) {
            case FULL:
                // views.add(new UiView());
            case SCROLLING:
                // views.add(new UiView());
            case CHECK:
                // views.add(new UiView());
            default:
                System.out.println("Error: Incapatable view selected: " + view);
        }
    }

    /**
     * Gets a list of the possible values
     * 
     * @return the list of possible values
     */
    public List<Object> getAllValues() {
        return allValues;
    }

    /**
     * Sets the list of Possible Values
     * 
     * @param allValues the list of the Possible values
     */
    public void setAllValues(List<Object> allValues) {
        this.allValues = allValues;
    }

    /**
     * Gets a list of the Current values
     * 
     * @return the list of chosen values
     */
    public List<Object> getCurrentValues() {
        return currValues;
    }

    /**
     * Sets the list of Current values
     * 
     * @param currValues the list of chosen values
     */
    public void setValues(List<Object> currValues) {
        this.currValues = currValues;
    }

    /**
     * Gets a list of all the model's views
     * 
     * @return the list of views for this model
     */
    public List<UiView> getViews() {
        return views;
    }

    /**
     * Sets the list of the model's views
     * 
     * @param views the list of view for this model
     */
    public void setViews(List<UiView> views) {
        this.views = views;
    }
}
