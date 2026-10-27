# Automação BugBank - Java 24 + Selenium + JUnit 5

Prova final de Automação Web (Fundatec). Site testado: https://bugbank.netlify.app/

Fluxo: cadastra 2 contas com saldo -> transfere da conta A para a B -> valida o extrato da A -> valida o extrato da B.

## Estrutura (camadas)
- `Framework`    : DriverManager, TypeBrowser, TestBase, JsUtils
- `PageObjects`  : mapeamento dos elementos (ver `mapeamento.txt`)
- `Tasks`        : passos de negócio (cadastrar, logar, transferir, extrato)
- `Validacao`    : asserts
- `Dados`        : massa de dados (Conta, Moeda)
- `TestCases`    : teste final

## Como rodar no IntelliJ
1. File > Open > pasta do projeto (onde está o `pom.xml`) e aguardar o Maven importar.
2. File > Project Structure > Project SDK = JDK 24.
3. Abrir `TestCases/RealizarTransferenciaComSucessoTest` e clicar no play verde.

## Lições aprendidas (para reaproveitar em próximos projetos)
- **Espera explícita:** o BugBank é React; os elementos aparecem de forma assíncrona. A `BasePage` usa `WebDriverWait`.
- **ElementClickInterceptedException:** botões cobertos por outro elemento. Solução: `JsUtils.clicarSeguro` (rola até o elemento e, se preciso, clica via JavaScript).
- **Formulário que mantém estado:** o cadastro não limpa os campos entre uma conta e outra. Solução: `JsUtils.digitar` (Ctrl+A antes de digitar) e voltar ao login após cada cadastro.
- **Toggle customizado:** `isSelected()` não reflete o estado real. Solução: o próprio código controla o estado (`toggleLigado` no `CadastroTask`).
- **Não engolir erros:** asserts sem `try/catch`, para o teste falhar de verdade quando algo estiver errado.
- **Diagnóstico:** em caso de dúvida sobre o estado da tela, imprimir valores (`System.out.println`) temporariamente e remover depois.
