package swt_widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
 
public class VerticalRadioButtonDemo {
 
    public static void main(String[] args) {
 
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("select who CAN see my posts: ");
 
        RowLayout rowLayout = new RowLayout();
        rowLayout.marginLeft = 10;
        rowLayout.marginTop = 10;
        rowLayout.spacing = 15;
        shell.setLayout(rowLayout);
        

        shell.setBackground(display.getSystemColor(SWT.COLOR_GRAY));
        shell.setBackgroundMode(SWT.INHERIT_FORCE);
 
 
        // Vertical Group      
        Group contactsGroup = new Group(shell, SWT.NONE);
        contactsGroup.setLayout(new RowLayout(SWT.VERTICAL));
     
        Button buttonFollowers = new Button(contactsGroup, SWT.RADIO);
        buttonFollowers.setText("Enable to Followers");               
        Button buttonFollowerHide = new Button(contactsGroup, SWT.RADIO);
        buttonFollowerHide.setText("Hide from Followers");
 
        Group follosGroup = new Group(shell, SWT.NONE);
        follosGroup.setLayout(new RowLayout(SWT.VERTICAL));
        
        Button buttonFollows = new Button(follosGroup, SWT.RADIO);
        buttonFollows.setText("Enable to Follows");       
        Button buttonFollowsHide = new Button(follosGroup, SWT.RADIO);
        buttonFollowsHide.setText("Hide from Follows");
 
        Group frisGroup = new Group(shell, SWT.NONE);
        frisGroup.setLayout(new RowLayout(SWT.VERTICAL));
        
        Button buttonFriends = new Button(frisGroup, SWT.RADIO);
        buttonFriends.setText("Enable to My Friends");
        Button buttonFrisHide = new Button(frisGroup, SWT.RADIO);
        buttonFrisHide.setText("Hide from My Friends");
        
        Group strangerGroup = new Group(shell, SWT.NONE);
        strangerGroup.setLayout(new RowLayout(SWT.VERTICAL));
        
        Button buttonStrangers = new Button(strangerGroup, SWT.RADIO);
        buttonStrangers.setText("Enable to Strangers");
        Button buttonStrangersHide = new Button(strangerGroup, SWT.RADIO);
        buttonStrangersHide.setText("Hide from Strangers");
        
        
        
    
 
 
        shell.setSize(400, 250);
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }
 
}