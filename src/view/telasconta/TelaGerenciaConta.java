package view.telasconta;

import view.ClearConsole;
import view.TratamentodeEntradas;

/**
 * A classe TelaGerenciaConta e responsavel por disponibilizar um menu principal
 * relacionado as acoes possiveis para um usuario, esta classe utiliza apenas
 * recursos de outras views para o seu funcionamento.
 * 
 * @author Adler_Moraes
 *
 */

public class TelaGerenciaConta {
	/**
	 * O metodo menuGerenciaContas funciona como uma tela para escolhas de acoes
	 * relacionadas a contas, sao elas: realizar transacao, exibir extrato,
	 * cadastrar uma nova conta, excluir uma conta existente, consultar as
	 * informacoes das suas contas e uma opcao para sair. caso uma opcao invalida
	 * seja utilizada, uma mensagem de erro sera emitida.
	 */

	public static void menuGerenciaContas() {
		int opcao;
		boolean sair = false;

		do {
			try {
				new ClearConsole();
				System.out.println();
				System.out.println("\t\t\t*******************************************************");
				System.out.println("\t\t\t*\t           CPAN BANCO CENTER                  *");
				System.out.println("\t\t\t*******************************************************");
				System.out.println("\t\t\t\t\n\t\t\t\t");
				System.out.println("\t \t\t\t**************************************");
				System.out.println("\t\t\t\t*           GERENCIAR CONTA           *");
				System.out.println("\t \t\t\t**************************************");
				System.out.println("\t\t\t\t\n\t\t\t\t");
				System.out.println("\t\t\t\t**************************************");
				System.out.println(
						"\t\t\t\t*   " + MenuConta.REALIZARTRANSACAO.opcao + ".Transacoes                     *");
				System.out.println("\t\t\t\t**************************************");
				System.out
						.println("\t\t\t\t*   " + MenuConta.EXIBIREXTRATO.opcao + ".Exibir Extrato de uma Conta    *");
				System.out.println("\t\t\t\t**************************************");
				System.out
						.println("\t\t\t\t*   " + MenuConta.CADASTRARCONTA.opcao + ".Cadastrar Conta                *");
				System.out.println("\t\t\t\t**************************************");
				System.out.println("\t\t\t\t*   " + MenuConta.EXCLUIRCONTA.opcao + ".Excluir Conta                  *");
				System.out.println("\t\t\t\t**************************************");
				System.out
						.println("\t\t\t\t*   " + MenuConta.CONSULTARCONTA.opcao + ".Consultar Conta(s) em seu Nome *");
				System.out.println("\t\t\t\t**************************************");
				System.out.println("\t\t\t\t*   " + MenuConta.DEFINIRCONTAPADRAO.opcao
						+ ".Definir Conta Padrao                     *");
				System.out.println("\t\t\t\t**************************************");
				System.out.println("\t\t\t\t*   " + MenuConta.ATUALIZARSENHACONTA.opcao
						+ ".Atualizar Senha da Conta                     *");
				System.out.println("\t\t\t\t**************************************");
				System.out.println("\t\t\t\t*   " + MenuConta.SAIR.opcao + ".Voltar                           *");
				System.out.println("\t\t\t\t**************************************");
				opcao = TratamentodeEntradas.trataEntradaOpcao();

				switch (MenuConta.menuOpcao(opcao)) {
				case REALIZARTRANSACAO:
					TelaOpcoesTransacoes.menuTransacoes();
					break;

				case EXIBIREXTRATO:
					TelaExtratoConta.extratoConta();
					break;

				case CADASTRARCONTA:
					TelaCadastraConta.formularioCadastroConta();
					break;

				case EXCLUIRCONTA:
					TelaExcluiConta.menuExcluirConta();
					break;

				case CONSULTARCONTA:
					TelaConsultaConta.consultaConta();
					break;
				case DEFINIRCONTAPADRAO:
					TelaDefineContaPadrao.menuDefineContaPadrao();
					break;
				case ATUALIZARSENHACONTA:
					TelaAtualizaSenhaConta.menuAtualizaSenhaConta();
					break;
				case SAIR:
					sair = true;
					break;
				}
			} catch (Exception e) {
				System.out.println();
				System.out.println("\t\t\t\tOpcao Invalida!");
				System.out.println();
			}
		} while (!sair);
	}
}
