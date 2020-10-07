import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.SWT;

public class TestRadioButtons {
	 public static void main(String[] args) {

	        List<Object> gender = new LinkedList<>();
	        gender.add("Male");
	        gender.add("Female");
	        gender.add("I don't want to answer");
	        OneFromN model2 = new OneFromN();
	        model2.addManyToAllValues(gender);
	        
	        RadioButtonView view2 = new RadioButtonView(model2, Views.RADIOB);
	        model2.addView(view2);
	        model2.getViews().get(0).setGroupTitle("Gender:");
	        model2.getViews().get(0).setGroupBackground(SWT.COLOR_GRAY);
	        
	        System.out.println("Before " + model2.getCurrValue());
	        model2.launchUi();
	        System.out.println("After " + model2.getCurrValue());
	 }
}
