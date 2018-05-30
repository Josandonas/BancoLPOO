package view.telasconta;

import controller.ContaDAO;
import controller.Controller;
import model.Conta;
import view.ClearConsole;
import view.EntradaDeDados;
import view.TratamentodeEntradas;
import view.telaspessoa.MenuExcluirConta;

/**
 * A classe TelaExcluiConta e responsavel por disponibilizar a visualizacao do
 * menu referente a exclusao de uma conta, utilizando de seus metodos para
 * acessar as informacoes e outros metodos necessarios que estao em outras
 * classes presentes no Controller, Model e em outras Views.
 * 
 * @author Adler_Moraes
 *
 */
public class TelaExcluiConta {
	/**
	 * O metodo menuExcluirConta utiliza primeiramente de uma identificacao de
	 * pessoa, para confirmacao da identidade, impossibilitando que uma conta seja
	 * excluida erroneamente. Apos a validacao, o menu e imprimido para a
	 * visualizacao mostrando as opcoes disponiveis, no caso, sim ou nao, para a
	 * confirmacao da exclusao. Caso a conta exista, ela sera excluida, caso
	 * contrario, uma mensagem de conta nao encontrada sera emitida, assim como
	 * mensagens de erro para se o usuario digitar uma opcao invalida alem das
	 * possiveis, ou se alguma informacao da identidade for invalida.
	 */
	public static void menuExcluirConta() {
		int opcao;
		boolean sair = false;
		Conta conta;

		do {
			try {
				new ClearConsole();
				System.out.println();
				System.out.println("\t\t\t*******************************************************");
				System.out.println("\t\t\t*\t           CPAN BANCO CENTER                  *");
				System.out.println("\t\t\t*******************************************************");
				System.out.println("\t\t\t\t\n\t\t\t\t");
				System.out.println("\t \t\t\t**************************************");
				System.out.println("\t\t\t\t*            EXCLUIR CONTA            *");
				System.out.println("\t \t\t\t**************************************");
				System.out.println("\t\t\t\tDeseja realmente excluir uma conta bancaria?");
				System.out.println("\t\t\tAo excluir, seus dados serão perdidos permanentemente");
				System.out.println("\t \t\t\t**************************************");
				System.out.println("\t\t\t\t*   " + MenuExcluiConta.NAO.opcao + ".N�o    *");
				System.out.println("\t \t\t\t**************************************");
				System.out.println("\t\t\t\t*   " + MenuExcluiConta.SIM.opcao + ".Sim    *");
				System.out.println("\t \t\t\t**************************************");
				System.out.println("\t\t\t\t\n\t\t\t\t");
				opcao = TratamentodeEntradas.trataEntradaOpcao();

				switch (MenuExcluirConta.menuConfirma(opcao)) {
				case NAO:
					sair = true;
					break;

				case SIM:
					try {
						System.out.println();
						System.out.println("\t\t\t\t        Confirme sua Identidade            ");
						System.out.println();
						if (Controller.validaLogin(TratamentodeEntradas.trataEntradaCpf(), EntradaDeDados.lerSenha())) {
							try {
								conta = ContaDAO.read(TratamentodeEntradas.trataEntradaNumeroConta(),
										EntradaDeDados.lerSenhaConta());
								if (conta != null) {
									ContaDAO.delete(conta, Controller.getSessao());
									// ContaDAO.salvarContas();
									// PessoaDAO.salvarPessoas();
									System.out.println();
									System.out.println("[\t\t\t\t[Conta removida com sucesso]");
									System.out.println();
								}

							} catch (Exception ex) {
								System.out.println();
								System.out.println("\t\t\t\t[Conta nao encontrada]");
								System.out.println();
							}
						}

					} catch (Exception ex) {
						System.out.println();
						System.out.println("\t\t\t\t[Usuario e/ou senha incorreto(s)]");
						System.out.println();
					}

				}

			} catch (Exception e) {
				System.out.println();
				System.out.println("\t\t\t\tOpcao Invalida!");
				System.out.println();
			}
		} while (!sair);
	}
}