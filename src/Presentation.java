import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.SWT;

public class Presentation {

	 public static void main(String[] args) {

	        List<Object> gender = new LinkedList<>();
	        gender.add("Male");
	        gender.add("Female");
	        gender.add("I don't want to answer");
	        
	        OneFromN model = new OneFromN();
	        model.addManyToAllValues(gender);
	        
	        BoxButtonView view = new BoxButtonView(model);
	        view.setGroupBackground(SWT.COLOR_DARK_GRAY);
	        model.addView(view);
	        model.setViewName(1, "Gender");
	        
	        RadioButtonView view2 = new RadioButtonView(model);
	        view2.setGroupBackground(SWT.COLOR_DARK_CYAN);
	        model.addView(view2);
	        model.setViewName(2, "Gender");
	        
	        System.out.println("Before " + model.getCurrValue());
	        model.launchUi();
	        System.out.println("After " + model.getCurrValue());
	        
	        
	        
	        
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

     
}
