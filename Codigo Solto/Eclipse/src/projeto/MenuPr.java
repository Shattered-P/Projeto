package projeto;

import java.io.File;
import java.util.*;

public class MenuPr {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		menu();

	}

	public static int menu() {
		int op;
		do {
			System.out.print("1 - Ler informa��o do ficheiro de texto \n2 - Listar informa��o de deputados \n3 - Alterar informa��o de deputado \n4 - Ver vota��o \n5 - Ver informa��o deputados  na vota��o \n6 - Ver Resultados da ultima vota��o \n7 - Ver resultados por idades \n8 - Sair");
			op = sc.nextInt();
			switch (op) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				System.exit(0);
			default:
				System.out.print("Op��o Inv�lida");
			}
		} while (true);
	}
}