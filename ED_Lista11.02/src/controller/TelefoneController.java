package controller;

import otavioolinto.fila.Fila;
import javax.swing.JOptionPane;

public class TelefoneController {

	public TelefoneController() {
		super();
	}
	
	public void inserirLigacao(Fila<String> fila, String numero) {
		
		fila.insert(numero);
		
	}
	
	public void consultarLigacoes(Fila<String> fila)throws Exception {
		
		if(fila.isEmpty()) throw new Exception("Não há registro de chamadas no momento");
		
		JOptionPane.showMessageDialog(null, "Ligação recebida:\n\n"+fila.remove());
		
		int opc = 0;
		
		do {
			
			opc = Integer.parseInt(JOptionPane.showInputDialog("Deseja ver o próximo registro?"+
															   "\n1 - Sim"+
															   "\n9 - Não"));
			
			switch(opc) {
			
				case 1:
					consultarLigacoes(fila);
					break;
					
				case 9:
					JOptionPane.showMessageDialog(null, "Voltando ao menu anterior.");
					break;
					
					
				default:
					JOptionPane.showMessageDialog(null, "Opção Inválida.\nTente novamente.");
					break;
			}
			
		}while(opc!=9);
	}

}