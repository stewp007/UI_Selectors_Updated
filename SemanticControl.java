import java.util.LinkedList;
import java.util.List;

/**
 * 
 */

/**
 * @author stewartpowell
 *
 */
public abstract class SemanticControl {
    /** The set of all possible values */
    private List<Object> allValues;
    /** The Current value selected */
    private Object currValue;
    /** The array of Instantiated Views for this Model */
    private List<UiView> views;

    /**
     * Constructor for Semantic Control
     */
    public SemanticControl() {
        this.allValues = new LinkedList<>();
        this.views = new LinkedList<>();
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

    /**
     * Gets the current value
     * 
     * @return the currValue or values
     */
    public Object getCurrValue() {
        return currValue;
    }

    /**
     * Sets the current value
     * 
     * @param currValue the new current value
     */
    public void setCurrValue(Object currValue) {
        this.currValue = currValue;
    }

}
