package Framework;

import Framework.Browser.DriverManager;
import Framework.Browser.TypeBrowser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class TestBase extends DriverManager {

    private static final String URL = "https://bugbank.netlify.app/";

    public static WebDriver getDriverManager() {
        return getDriver(TypeBrowser.CHROME);
    }

    @BeforeEach
    public void setUp() {
        getDriverManager().get(URL);
    }

    @AfterEach
    public void finish() {
        fecharDriver();
    }
}
