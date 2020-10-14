import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.SWT;

public class TestRadioButtons {
	 public static void main(String[] args) {

	        List<Object> gender = new LinkedList<>();
	        gender.add("Male");
	        gender.add("Female");
	        gender.add("I don't want to answer");
	        
	        OneFromN model = new OneFromN();
	        model.addManyToAllValues(gender);
	        BoxButtonView view = new BoxButtonView(model, Views.BOXB);
	        model.addView(view);
	        model.getViews().get(0).setGroupTitle("Gender:");
	        view.setGroupBackground(SWT.COLOR_DARK_CYAN);
	        
	        model.addManyToAllValues(gender);
	        RadioButtonView view2 = new RadioButtonView(model, Views.RADIOB);
	        model.addView(view2);
	        model.getViews().get(1).setGroupTitle("Gender:");
	        view2.setGroupBackground(SWT.COLOR_DARK_CYAN);
	        
	        System.out.println("Before " + model.getCurrValue());
	        model.launchUi();
	        System.out.println("After " + model.getCurrValue());
	  
	 }
}
