import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class AuthenticationGUI extends Application {
    public enum AccountType{ Admin, nah};
    private static void main(String[] args) {
    launch(args);
   }

    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Authentication");
	TextField usernameTxtFld = new TextField();
	PasswordField passwordTxtFld = new PasswordField();

	Label UserLbl = new Label("Username");
	Label PassLbl = new Label("Password");

	Button submit = new Button("Submit");
	submit.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent arg0) {
	        int i=0;

		String inputUser = "";
		String inputPass = "";
		String Username = "Tuna";
		String Password = "Magic";
		AccountType [] account={AccountType.Admin, AccountType.nah};

		inputUser = usernameTxtFld.getText();
		inputPass = passwordTxtFld.getText();
		if (inputUser.equals(Username) && (inputPass.equals(Password))) {
		    JOptionPane.showMessageDialog(null, "Welcome " + inputUser +
		    "! Please enjoy your stay, and contact management if you have any issues " + inputUser +".");
                    do {
		        AccountType select = (AccountType) JOptionPane.showInputDialog(null, 
			"select account type", "Account Type", JOptionPane.INFORMATION_MESSAGE, null, 
			account, account[0]);
			switch (select) {
			case Admin:
			    JOptionPane.showMessageDialog(null, "Welcome Admin " + inputUser);
			    System.exit(0);
			    break;
			    case nah:
			        JOptionPane.showMessageDialog(null, "Incorrect account type!");
				i++;
				break;
			}
		} while (i<3);

	} else {
            JOptionPane.showMessageDialog(null, "Failure! Incorrect username or password!");
	    }

	}
    });

    GridPane grid2 = new GridPane();
    grid2.setAlignment(Pos.CENTER);
    grid2.setVgap(10);

    grid2.add(UserLbl, 0, 0);
    grid2.add(PassLbl, 0, 1);
    grid2.add(usernameTxtFld, 1, 0);
    grid2.add(passwordTxtFld, 1, 1);
    grid2.add(submit, 1, 2);
    Scene scene = new Scene(grid2, 500, 500);
    primaryStage.setScene(scene);
    primaryStage.show();
    }
}
