package Validacao;

import PageObjects.GenericPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class GenericValidacao {

    private final GenericPage genericPage;

    public GenericValidacao(WebDriver driver) {
        genericPage = new GenericPage(driver);
    }

    public void validacaoModalContem(String trecho) {
        String texto = genericPage.getModalText().getText();
        Assertions.assertTrue(texto.toLowerCase().contains(trecho.toLowerCase()),
                "Mensagem do modal incorreta. Esperado conter '" + trecho + "' mas veio: '" + texto + "'");
    }
}
