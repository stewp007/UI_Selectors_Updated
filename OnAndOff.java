

/**
 * @author Serena
 *
 */
public class OnAndOff extends SemanticControl {


	
	    public OnAndOff() {
	        super();
	    }

	    /**
	     * Adds a view to the current list of views
	     * 
	     * @param view   a value to add to the current Values
	     * @param layout the layout of the presenter buttons
	     */
	    @Override
	    public void addView(Views view, boolean layout) {
	        switch (view) {
	            case FULL:
	                getViews().add(new CheckBoxView(this));
	                break;
	        
	            case TOGGLE:
	                getViews().add(new ToggleButtonView(this));
	                break;
	            default:
	                System.out.println("Error: Incapatable view selected: " + view);
	        }
	    }

	    /**
	     * Adds a UiView object to the list views of this presenter
	     * 
	     * @param view the new view to add to the model
	     */
	    public void addView(UiView view) {
	        if ((view.getType() == Views.FULL) || (view.getType() == Views.TOGGLE)) {
	            getViews().add(view);
	        } else {
	            System.out.println("Error: Non-valid view");
	        }
	    }

	}


