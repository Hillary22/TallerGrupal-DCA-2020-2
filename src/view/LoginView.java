package view;

import controller.Controller;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Login view class 

 * @author: Juan P. Sanin

 * @version: 1.0 11/9/2020

 */
public class LoginView {
	
	private Controller controller;
	private PImage loginScreen;
	private PImage loginBut, loginButUI, navigation;
	private PImage errorMessage;
	private boolean error;
	
	private PApplet app;

	public LoginView(PApplet app) {
		controller= new Controller();
		this.app = app;
		loginScreen = app.loadImage("../image/screens/loginScreen.png");
		navigation = app.loadImage("../image/screens/navigationBar.png");
		loginBut = app.loadImage("../image/interactive/loginButton.png");
		loginButUI = app.loadImage("../image/interactive/loginButtonUI.png");
		errorMessage = app.loadImage("../image/interactive/loginAlertMessage.png");
		error=false;
		
	}
	
	
	public void drawScreen() {
		if(error==true) {
			app.image(loginScreen, 0,0);
			app.image(navigation, -4, 0);
			app.image(loginBut, 544, 451);
			app.fill(0,95);
			app.rect(0,0,1280, 720);
			app.image(errorMessage,179, 273);
		
		}else {
			app.image(loginScreen, 0,0);
			app.image(navigation, -4, 0);
			if(app.mouseX>544 && app.mouseX<742 &&app.mouseY>451 && app.mouseY<497) {
				app.image(loginButUI, 544, 451);
			}else {
				app.image(loginBut, 544, 451);
			}
		}
		
		
	}


	public int changeScreen() {
		int screen=1;
		if(error==false) {
			if(app.mouseX>544 && app.mouseX<742 &&app.mouseY>451 && app.mouseY<497) {
				screen=3;
			}
			if(app.mouseX>723 && app.mouseX<746 &&app.mouseY>535 && app.mouseY<545) {
				screen=2;
			}
			if(app.mouseX>358 && app.mouseX<437 &&app.mouseY>28 && app.mouseY<43) {
				error=true;
			}
			if(app.mouseX>548 && app.mouseX<645 &&app.mouseY>28 && app.mouseY<43) {
				error=true;
			}
		}else {
			if(app.mouseX>550 && app.mouseX<750 &&app.mouseY>360 && app.mouseY<410) {
				error=false;
			}
		}
		
		
		
		
		
		
		
		return screen;
	}

	
	

	
	
	

}
