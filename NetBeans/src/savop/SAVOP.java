package savop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

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
        int numDeputados = 0;
        String assuntoVotado = null;

    }

    /**
     * Carrega informação dos deputados para memória a partir de ficheiro de
     * texto FILE_DEPUTADOS
     *
     * @param deputados - matriz de strings para guardar info dos deputados
     * @return do número de depotados inseridos na matriz
     * @throws FileNotFoundException
     */
    public static int lerInfoFicheiro(String[][] deputados) throws FileNotFoundException {

        Scanner fileIn = new Scanner(new File(FILE_DEPUTADOS));
        int numDeputados = 0;

        while (fileIn.hasNext() && numDeputados < MAX_DEPUTADOS) {
            String linha = fileIn.nextLine();

            if (linha.length() > 0) {
                // criar método numDeputados=guardarDadosDeputado(linha, deputados, numDeputados);

            }
        }
        fileIn.close();
        return numDeputados;

    }

    public static int guardarDadosDeputado(String linha, int[][] deputados, int numDeputados) {
        return 0;

    }

}

class Utilitarios {

    /**
     * o método recebe uma string com um nome completo e retorna apenas o
     * primeiro e último nome
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
     * método para calcular a idade de um deputado
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
    public static int menu() {
        int op;
        do {
            System.out.print("1 - Ler informação do ficheiro de texto \n2 - Listar informação de deputados \n3 - Alterar informação de deputado \n4 - Ver votação \n5 - Ver informação deputados  na votação \n6 - Ver Resultados da ultima votação \n7 - Ver resultados por idades \n8 - Sair");
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
                System.out.print("Opção Inválida");
            }
        } while (true);
    }

}
