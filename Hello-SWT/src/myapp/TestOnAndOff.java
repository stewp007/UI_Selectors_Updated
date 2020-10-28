package myapp;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.SWT;


public class TestOnAndOff {
	
	public static void main(String[] args) {
		
		List<Object> group = new LinkedList<>();
		group.add("My Friends");
		group.add("Follows");
		group.add("Followers");
		group.add("Strangers");
		group.add(null);
		
		OnAndOff model = new OnAndOff();
		model.addManyToAllValues(group);//can be changed depends on the user
		
		CheckBoxView checkBoxView = new CheckBoxView(model);
		ToggleButtonView tButtonview = new ToggleButtonView(model);
		
		model.addView(checkBoxView);
		model.addView(tButtonview);
			
		model.getViews().get(0).setGroupTitle("Select who CAN NOT see the posts on my account:");
		model.getViews().get(1).setGroupTitle("Select Who CAN NOT see my posts on my account:");
		
		System.out.println("Before Selecting Group: " + model.getCurrValue());
		model.launchUi();
		System.out.println("The Following Group can see your posts: " + model.getCurrValue());
		
		
		
	}
	

}
