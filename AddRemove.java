import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddRemove {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OMEN\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        addElements(driver, 100);

        removeElements(driver, 50);

        checkRemainingElements(driver, 50);


        driver.quit();
    }

    public static void addElements(WebDriver driver, int count) {
        WebElement addButton = driver.findElement(By.xpath("//button[text()='Add Element']"));

        for (int i = 0; i < count; i++) {
            addButton.click();
        }
    }
    public static void removeElements(WebDriver driver, int count) {
        WebElement deleteButton;

        for (int i = 0; i < count; i++) {
            deleteButton = driver.findElement(By.xpath("//button[text()='Delete']"));
            deleteButton.click();
        }
    }

    public static void checkRemainingElements(WebDriver driver, int count) {
        int remainingElements = driver.findElements(By.className("added-manually")).size();

        if (remainingElements == count) {
            System.out.println("Осталось " + count + " элементов");
        } else {
            System.out.println("Осталось неверное количество элементов");
        }
    }
}
