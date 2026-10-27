package TestCases;

import Dados.Conta;
import Framework.TestBase;
import Tasks.CadastroTask;
import Tasks.ExtratoTask;
import Tasks.LoginTask;
import Tasks.TransferenciaTask;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class RealizarTransferenciaComSucessoTest extends TestBase {

    private final WebDriver driver = getDriverManager();

    CadastroTask cadastroTask = new CadastroTask(driver);
    LoginTask loginTask = new LoginTask(driver);
    TransferenciaTask transferenciaTask = new TransferenciaTask(driver);
    ExtratoTask extratoTask = new ExtratoTask(driver);

    @Test
    public void realizarTransferencia() {

        Conta contaOrigem = Conta.origem();
        Conta contaDestino = Conta.destino();
        double valor = 150;
        String descricao = "Transferencia de teste";

        // 1. Cadastra as duas contas, ambas com saldo
        cadastroTask.cadastrarConta(contaOrigem);
        cadastroTask.cadastrarConta(contaDestino);

        // 2. Conta de origem: transfere e valida o extrato (saldo debitado)
        loginTask.efetuarLogin(contaOrigem);
        transferenciaTask.realizarTransferencia(contaOrigem, contaDestino, valor, descricao);
        extratoTask.validarExtrato(contaOrigem, descricao, valor);
        loginTask.efetuarLogout();

        // 3. Conta de destino: valida o extrato (valor recebido)
        loginTask.efetuarLogin(contaDestino);
        extratoTask.validarExtrato(contaDestino, descricao, valor);
        loginTask.efetuarLogout();
    }
}
