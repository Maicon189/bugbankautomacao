package Validacao;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class LoginValidacao {

    private final LoginPage loginPage;
    private final HomePage homePage;

    public LoginValidacao(WebDriver driver) {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    public void validacaoUsuarioLogado(String nome) {
        String texto = homePage.getNomeText().getText();
        Assertions.assertTrue(texto.contains(nome),
                "Usuario logado incorreto. Esperado conter '" + nome + "' mas veio: '" + texto + "'");
    }

    public void validacaoTelaLoginExibida() {
        Assertions.assertTrue(loginPage.getAcessarButton().isDisplayed(),
                "A tela de login nao foi exibida apos o logout");
    }
}
