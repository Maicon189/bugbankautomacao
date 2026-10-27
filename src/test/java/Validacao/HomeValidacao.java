package Validacao;

import Dados.Conta;
import Dados.Moeda;
import PageObjects.HomePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class HomeValidacao {

    private final HomePage homePage;

    public HomeValidacao(WebDriver driver) {
        homePage = new HomePage(driver);
    }

    public void validacaoSaldoNaHome(Conta conta) {
        String esperado = Moeda.formatar(conta.getSaldo());
        String texto = homePage.getSaldoText().getText();
        Assertions.assertTrue(texto.contains(esperado),
                "Saldo na home incorreto. Esperado conter '" + esperado + "' mas veio: '" + texto + "'");
    }
}
