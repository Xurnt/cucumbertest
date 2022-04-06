package StepDefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AuthentificationSteps {
	private WebDriver driver;

	@Given("je suis sur la page login")
	public void je_suis_sur_la_page_login() {
		
		//Préconditions
		System.setProperty("webdriver.gecko.driver", "C:/Users/Ludovic/geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	    
		// Naviguer vers la page login
		driver.get("http://ats.faimerecruiter.com/");
	}
	
	@When("je saisi username: {string} And je saisi password: {string} And je clique sur Login")
	public void je_saisi_username_and_je_saisi_password_and_je_clique_sur_login(String username, String password) {

		// Instanciation
		WebElement ObjUsername =  driver.findElement(By.xpath("//input[@id='username']"));
		WebElement ObjPassword =  driver.findElement(By.xpath("//input[@id='password']"));
		WebElement ObjLogin =  driver.findElement(By.xpath("//input[@value='Login']"));
		
		// Traitement du scénario en utilisant les différentes méthodes associées aux objets instanciés
		ObjUsername.clear();
		ObjUsername.sendKeys(username);
		ObjPassword.clear();
		ObjPassword.sendKeys(password);
		ObjLogin.submit();
	}
	
	@Then("{string}")
	public void string(String resultatAttendu) throws InterruptedException {
		// Instanciation d'un temporisateur wait pour temporiser à chaqque changement de page
		WebDriverWait wait = new WebDriverWait(driver, 5);
		Thread.sleep(1000);
		String ResultatActuel = "";
		if(driver.findElements(By.xpath("//p[@class='failure']")).size() != 0) {
			try {
				WebElement ObjMsgErreur =  driver.findElement(By.xpath("//p[@class='failure']"));
				if(ObjMsgErreur.getText().contentEquals("Invalid username or password.")) {
				    ResultatActuel="Msg Erreur";
				} else {
				    ResultatActuel=ObjMsgErreur.getText();
				}

			} catch(Exception exception) {
				ResultatActuel = exception.toString();
			}

		} else {
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Logout')]")));
				WebElement ObjLogout =  driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
				if(driver.getCurrentUrl().contentEquals("http://ats.faimerecruiter.com/index.php?m=home")) {
					ResultatActuel = "Connexion et redirection vers le dashboard";
				} else {
					ResultatActuel = "Page actuel:" + driver.getCurrentUrl();
				}
			    ObjLogout.click();
			} catch(Exception exception) {
				ResultatActuel = exception.toString();
			}
		}
	    driver.quit();
		assertEquals(resultatAttendu, ResultatActuel);
	}
}
