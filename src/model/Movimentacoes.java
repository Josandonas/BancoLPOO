package model;

import java.io.Serializable;
import java.util.Date;
/**
 * @author Allison
 * @author Valdenize
 * @author Helmuth
 *Classe que representa as movimentacoes do Banco
*/

public class Movimentacoes implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date date;
	private Conta conta;
	private Conta destino;
	private String nomeOperacao;
	private String descricao;
	private double valorOperacao;
	private int numero_operacao;
	private double saldo_anteior;
	private double saldo_atual;

	
	
	/**
	 * @param date
	 * @param conta
	 * @param descricao
	 * @param valor
	 * @param numero_operacao
	 */
	public Movimentacoes(Date date,Conta conta, String descricao, double valor, int numero_operacao){
		this.setDate(date);
		this.setConta(conta);
		this.setNomeOperacao(numero_operacao);
		this.setDescricao(descricao);
		this.setValorOperacao(valor);
		this.setNumero_operacao(numero_operacao);
		this.setSaldo_anteior(conta.getSaldo()-valor);
		this.setSaldo_atual(conta.getSaldo());
	}

	/**
	 * @param date
	 * @param destino
	 * @param conta
	 * @param descricao
	 * @param valor
	 * @param numero_operacao
	 */
	public Movimentacoes(Date date,Conta conta,Conta destino, String descricao, double valor, int numero_operacao){
		this.setDate(date);
		this.setConta(conta);
		this.setDestino(destino);
		this.setNomeOperacao(numero_operacao);
		this.setDescricao(descricao);
		this.setValorOperacao(valor);
		this.setNumero_operacao(numero_operacao);
		this.setSaldo_anteior(conta.getSaldo()-valor);
		this.setSaldo_atual(conta.getSaldo());
	}
	
	
	/**
	 * Metodo que retorna o nome da operacao
	 * @return String
	 */
	public String getNomeOperacao() {
		return nomeOperacao;
	}

	/**
	 * Metodo que insere o nome da operacao a partir do numero
	 * @param numero_operacao
	 */
	public void setNomeOperacao(int numero_operacao) {
		if(numero_operacao == 1){
			this.nomeOperacao="Saque";
		}else if(numero_operacao == 2){
			this.nomeOperacao="Deposito";
		}else if(numero_operacao == 3){
			this.nomeOperacao ="Transferencia";
		}
	}

	/**
	 * Metodo que retorna o valor da operacao
	 * @return float
	 */
	public double getValorOperacao() {
		return valorOperacao;
	}

	/**
	 * Metodo que insere o valor da operacao
	 * @param valorOperacao
	 */
	public void setValorOperacao(double valorOperacao) {
		this.valorOperacao = valorOperacao;
	}

	/**
	 * Metodo que retorna a data da operacao
	 * @return  date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Metodo que insere a data da operacao
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Metodo que retorna a conta em que ocorreu a operacao
	 * @return conta
	 */
	public Conta getConta() {
		return conta;
	}

	/**
	 * Metodo que insere a conta que ocorreu a operacao
	 * @param conta the conta to set
	 */
	public void setConta(Conta conta) {
		this.conta = conta;
	}

	/**
	 * Metodo que retorna a conta que foi destinatario da operacao transferencia
	 * @return the destino
	 */
	public Conta getDestino() {
		return destino;
	}

	/**
	 * Metodo que insere a conta destino de uma operacao transferencia
	 * @param destino the destino to set
	 */
	public void setDestino(Conta destino) {
		this.destino = destino;
	}

	/**
	 * Metodo que retorna o numero que representa a operacao
	 * @return the numero_operacao
	 */
	public int getNumero_operacao() {
		return numero_operacao;
	}

	/**
	 * Metodo que insere o numero que representa a operacao
	 * @param numero_operacao the numero_operacao to set
	 */
	public void setNumero_operacao(int numero_operacao) {
		this.numero_operacao = numero_operacao;
	}

	/**
	 * Metodo que retorna o saldo anterior a operacao
	 * @return the saldo_anteior
	 */
	public double getSaldo_anteior() {
		return saldo_anteior;
	}

	/**
	 * Metodo que insere o saldo anterior a uma operacao
	 * @param saldo_anteior the saldo_anteior to set
	 */
	public void setSaldo_anteior(double saldo_anteior) {
		this.saldo_anteior = saldo_anteior;
	}

	/**
	 * Metodo que retorna a descricao da operacao realizada
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Metodo que insere a descricao da operacao
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
     * Metodo toString, retorna algumas das informacoes contidas 
     * nos atributos da classe e outras das classes Pessoa e Conta 
     * para simplificar as informações de Movimentacao ao usuário.
     * @return String
     */
	@Override
	public String toString() {
		return "Data: "+ this.getDate()+
				"\nNome: "+this.getConta().getPessoa().getNome()+
				"\nAgencia: "+ this.getConta().getAgencia()+
				"\nNumero: "+ this.getConta().getNumero()+
				"\nSaldo anterior: "+this.getSaldo_anteior()+
				"\nDescricao: "+this.getDescricao()+
				"\nValor: "+this.getValorOperacao() +
				"\nOperacao: "+this.getNomeOperacao()+
				"\nSaldo atual: "+this.getSaldo_atual();
	}

	/**
     * Metodo que retorna o saldo apos a realizacao da operacao
	 * @return the saldo_atual
	 */
	public double getSaldo_atual() {
		return saldo_atual;
	}

	/**
	 * Metodo que insere o saldo da conta apos uma operacao
	 * @param saldo_atual the saldo_atual to set
	 */
	public void setSaldo_atual(double saldo_atual) {
		this.saldo_atual = saldo_atual;
	}
	
}

