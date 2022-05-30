import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {
	
	@FXML
	
	private Label result;
	private String operator ="";
	private boolean start = true;

	private MainOperator ops = new MainOperator();
	
	//check the operator char location
	private int index=0;
	
	//calculate result
	private float res = 0;
	

	// button typed in checking 
	@FXML
	public void process_formula(ActionEvent event) {
		if(start) {
		result.setText("");
		index = 0;
		start = false;
		res = 0;
		}
		
		//receive text from button
		String value = ((Button)event.getSource()).getText();
		
		//pre string on the monitor
		String pre = result.getText();
		
		result.setText(result.getText()+value);
		
		if(index ==0 && !result.getText().equals("")&&(value.equals("+")||value.equals("-")||value.equals("/")||value.equals("*")))
		{
			index = pre.length();
			operator = value;
		//	result.setText(result.getText()+" "+value);
			
		}else if(value.equals("=")) {
			if(isNumeric(pre.substring(0,index))&&isNumeric(pre.substring(index+1))) {
			float num1 = Float.parseFloat(pre.substring(0,index));
			float num2 = Float.parseFloat(pre.substring(index+1));
			//System.out.println(num1);
			//System.out.println(num2);
			if(operator.equals("+")) {
				
				res = ops.add( num1, num2) ;
				
			}else if (operator.equals("-")) {
				
				res = ops.minus( num1, num2) ;
				
			}else if (operator.equals("/")) {
				//your devide function
				res = ops.divide(num1, num2);
			}else {
				//your multiple function
                res = ops.multiply(num1, num2);
			}
							
			result.setText(res+"");		
				
			} else {
				result.setText("error! Please re-type!");
				
			}
			start = true;
			
		}else if(value.equals("n^2")||value.equals("abs")||value.equals("sqrt")||value.equals("!")) {
		
			if(isNumeric(pre)) {
			
				float num = Float.parseFloat(pre);
				
				if(value.equals("abs")) {					
					// your abs funciton
					res = ops.absolute(num);

				}else if(value.equals("sqrt")) {
					// your sqrt funciton
					res = ops.root(num);
					
				}else if(value.equals("n^2")){
					res = ops.square(num);	
					
				}else {
					res = ops.factorial(num);
				}
				
				result.setText(res+"");	
				
		}else {
			
			result.setText("error! Please re-type!");	
		}
			start = true;			
		}	
	}
		
	//check the string is number or not
	public boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}	
}
