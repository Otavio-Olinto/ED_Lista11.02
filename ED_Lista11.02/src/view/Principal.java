package view;

import otavioolinto.fila.Fila;

import javax.swing.JOptionPane;

import controller.TelefoneController;

public class Principal {

	public static void main(String[] args) {
		// Criando a fila de Strings
		Fila<String> fila = new Fila<>(String.class);
		
		// Instanciando os métodos da classe TelefoneController
		TelefoneController metodo = new TelefoneController();
		
		int opc = 0;
		
		do {
			
			opc = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção desejada:"+
															   "\n1 - Insirir Ligação"+
															   "\n2 - Consultar Ligações"+
															   "\n3 - Sair"));
			
			switch(opc) {
			
				case 1:
					String numero = JOptionPane.showInputDialog("Qual o número deixou recado?");
					metodo.inserirLigacao(fila, numero);
					break;
					
				case 2:
					try {
						
						metodo.consultarLigacoes(fila);
					}catch(Exception exc) {
						
						JOptionPane.showMessageDialog(null, exc.getMessage());
					}
					break;
				
				case 3:
					JOptionPane.showMessageDialog(null, "Fim da Operação");
					break;
					
					
				default:
					JOptionPane.showMessageDialog(null, "Opção Inválida.\nTente novamente.");
					break;
			}
			
		}while(opc!=3);
		
		System.exit(0);

	}

}
