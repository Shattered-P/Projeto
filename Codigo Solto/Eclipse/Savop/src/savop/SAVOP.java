package savop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;
import java.util.Formatter;

/**
 *
 * @author
 */
public class SAVOP {

    private final static int MAX_DEPUTADOS = 230;
    private final static String FILE_DEPUTADOS = "Deputados.txt";
    private final static String PAGINA_HTML = "Pagina.html";
    private final static int MAX_LINHAS_PAGINA = 5;
    private final static String LOG_ERROS_DEP = ("errosDeputados.txt");

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        String[][] deputados = new String[MAX_DEPUTADOS][4];
        char[] votacoes = new char[MAX_DEPUTADOS];
        String assuntoVotado = null;
        
        menu(deputados);

    }

    /**
     * Carrega informa��o dos deputados para mem�ria a partir de ficheiro de
     * texto FILE_DEPUTADOS
     *
     * @param deputados - matriz de strings para guardar info dos deputados
     * @return do n�mero de depotados inseridos na matriz
     * @throws FileNotFoundException
     */
    public static int lerInfoFicheiro(String[][] deputados) throws FileNotFoundException {

        Scanner fileIn = new Scanner(new File(FILE_DEPUTADOS));
        Formatter erros = new Formatter(new File(LOG_ERROS_DEP));
        int numDeputados = 0;

        while (fileIn.hasNext() && numDeputados < MAX_DEPUTADOS) {
            String linha = fileIn.nextLine();

            if (linha.length() > 0) {
                guardarDadosDeputado(linha, deputados, numDeputados, erros);// criar m�todo numDeputados=guardarDadosDeputado(linha, deputados, numDeputados);

            }
        }
        fileIn.close();
        erros.close();
        return numDeputados;

    }
    

    public static int guardarDadosDeputado(String linha, String[][] deputados, int numDeputados, Formatter erros) {
    	
    	
        String[] temp = linha.split(";");
        
        if (temp.length == 4) {
            
            String id = temp[0].trim();
            
            if (id.length() == 5) {
                deputados[numDeputados][0] = id;
                deputados[numDeputados][1] = temp[1].trim();
                deputados[numDeputados][2] = temp[2].trim();
                deputados[numDeputados][3] = temp[3].trim();
                numDeputados++;
            } else {
                erros.format("Linha incorreta porque %s incorreto", id);
            }
        } else {
            erros.format("LInha: %f _ Campo Incorreto:\n %s ",numDeputados, linha);
            
        }
        
        return numDeputados;
        
        



    }
    public static void listagemPaginada(String[][] deputados, int numDeputados){
    	int contPaginas = 0;
    	for(int i=0; i<numDeputados; i++){
    		if(){
    			
    		}
    	}
    }

    public static int menu(String deputados[][]) throws FileNotFoundException {
        int op;
        do {
            System.out.print("1 - Ler informa��o do ficheiro de texto \n2 - Listar informa��o de deputados \n3 - Alterar informa��o de deputado \n4 - Ver vota��o \n5 - Ver informa��o deputados  na vota��o \n6 - Ver Resultados da ultima vota��o \n7 - Ver resultados por idades \n8 - Sair");
            op = sc.nextInt();
            int numDeputados = 0;
            switch (op) {
                case 1:
                lerInfoFicheiro(deputados);
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

class Utilitarios {

    /**
     * o m�todo recebe uma string com um nome completo e retorna apenas o
     * primeiro e �ltimo nome
     *
     * @param nome
     * @return
     */
    public static String nomeApelido(String nome) {
        nome = nome.trim();
        int primeiro = nome.indexOf(' ');
        int ultimo = nome.lastIndexOf(' ');

        return nome.substring(0, primeiro) + nome.substring(ultimo);
    }

    public static void mostrarDataHoje() {
        Calendar hoje = Calendar.getInstance();
        System.out.println((hoje.get(Calendar.DAY_OF_MONTH)) + "/" + (hoje.get(Calendar.MONTH) + 1) + "/" + (hoje.get(Calendar.YEAR)));
    }

    /**
     * m�todo para calcular a idade de um deputado
     *
     * @param dataNasc - String com a data de nascimento no formato YYYYMMDD
     * @return
     */
    public static int idade(String dataNasc) {
        int ano = Integer.parseInt(dataNasc.substring(0, 4));
        int mes = Integer.parseInt(dataNasc.substring(4, 6));
        int dia = Integer.parseInt(dataNasc.substring(6, 8));

        Calendar hoje = Calendar.getInstance();

        int diaH = hoje.get(Calendar.DAY_OF_MONTH);
        int mesH = hoje.get(Calendar.MONTH) + 1;
        int anoH = hoje.get(Calendar.YEAR);

        if (mesH > mes || (mesH == mes && diaH > dia)) {
            return anoH - ano;
        } else {
            return anoH - ano - 1;
        }
    }

}