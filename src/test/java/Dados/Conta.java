package Dados;

public class Conta {

    private static final double SALDO_INICIAL_BUGBANK = 1000.00;

    private final String email;
    private final String nome;
    private final String senha;
    private final boolean comSaldo;

    private String numero;
    private String digito;
    private double saldo;

    public Conta(String email, String nome, String senha, boolean comSaldo) {
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.comSaldo = comSaldo;
        this.saldo = comSaldo ? SALDO_INICIAL_BUGBANK : 0.0;
    }

    public static Conta origem() {
        return new Conta("origem@teste.com", "Cliente Origem", "senha123", true);
    }

    public static Conta destino() {
        return new Conta("destino@teste.com", "Cliente Destino", "senha123", true);
    }

    public String getEmail() { return email; }
    public String getNome() { return nome; }
    public String getSenha() { return senha; }
    public boolean isComSaldo() { return comSaldo; }
    public String getNumero() { return numero; }
    public String getDigito() { return digito; }
    public double getSaldo() { return saldo; }

    public void setNumeroConta(String numero, String digito) {
        this.numero = numero;
        this.digito = digito;
    }

    public void debitar(double valor) { this.saldo -= valor; }
    public void creditar(double valor) { this.saldo += valor; }
}
