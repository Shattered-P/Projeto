/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savop;

import java.util.Calendar;
import java.util.Formatter;

/**
 * Classe que disponibiliza métodos de criação da estrutura de uma página HTML e
 * de inserção de diversos elementos HTML nessa página
 *
 * @author mcn
 */
public class PaginaHTML {

    /**
     * Iniciar Página HTML
     *
     * @param pag - ficheiro página
     * @param titulo - título da página
     */
    public static void iniciarPagina(Formatter pag, String titulo) {
        pag.format("<!DOCTYPE html>%n");
        pag.format("<html>%n");
        pag.format("<head>%n");
        pag.format("<meta charset='utf-8'>%n");
        pag.format("<title>%s</title>%n", titulo);
        pag.format("</head>%n");
        pag.format("<body>");
    }

    /**
     * Fechar a estrutura da página
     *
     * @param pag - ficheiro página
     */
    public static void fecharPagina(Formatter pag) {
        pag.format("</body>%n</html>");
    }

    /**
     * Fechar a estrutura da página incluindo um parágrafo final com a data
     * atual
     *
     * @param pag - ficheiro página
     */
    public static void fecharPaginaComData(Formatter pag) {
        Calendar hoje = Calendar.getInstance();
        int dia = hoje.get(Calendar.DAY_OF_MONTH);
        int mes = hoje.get(Calendar.MONTH) + 1;
        int ano = hoje.get(Calendar.YEAR);
        paragrafo(pag, "Data: " + dia + "/" + mes + "/" + ano);
        pag.format("</body>%n</html>");
    }

    /**
     * Cria na página um cabeçalho (header) de tamanho n
     *
     * @param pag - ficheiro página
     * @param n - tamanho do cabeçalho
     * @param conteudo - conteúdo do cabeçalho
     */
    public static void cabecalho(Formatter pag, int n, String conteudo) {
        pag.format("<h%d>%s</h%d>%n", n, conteudo, n);
    }

    /**
     * Cria na página um parágrafo
     *
     * @param pag - ficheiro página
     * @param conteudo - conteúdo do parágrafo
     */
    public static void paragrafo(Formatter pag, String conteudo) {
        pag.format("<p>%s</p>%n", conteudo);
    }

    /**
     * Iniciar a criação de uma tabela
     *
     * @param pag
     */
    public static void iniciarTabela(Formatter pag) {
        pag.format("<table>%n");
    }

    /**
     * Fechar a tabela criada
     *
     * @param pag
     */
    public static void fecharTabela(Formatter pag) {
        pag.format("</table>%n");
    }

    /**
     * Insereir na tabela uma linha de cabeçalhos
     *
     * @param pag
     * @param info
     */
    public static void linhaCabecalhoTabela(Formatter pag, String[] info) {
        pag.format("<tr>");
        for (int i = 0; i < info.length; i++) {
            pag.format("<th>%s</th>", info[i]);
        }
        pag.format("</tr>%n");
    }

    /**
     * Inserir na tabela as várias linhas com o conteúdo
     *
     * @param pag - ficheiro página
     * @param info - matriz corpo da tabela
     * @param nEls - número de linhas da matriz info
     */
    public static void corpoTabela(Formatter pag, String[][] info,
            int nEls) {

        for (int i = 0; i < nEls; i++) {
            pag.format("<tr>");
            for (int j = 0; j < info[i].length; j++) {
                pag.format("<td>%s</td>", info[i][j]);
            }
            pag.format("</tr>%n");
        }
    }

    /**
     * Cria na página uma tabela sem linha de titulos
     *
     * @param pag - ficheiro página
     * @param info - matriz corpo da tabela
     * @param nEls - número de linhas da matriz info
     */
    public static void criarTabelaSemLinhaTitulos(Formatter pag,
            String[][] info, int nEls) {

        iniciarTabela(pag);
        corpoTabela(pag, info, nEls);
        fecharTabela(pag);

    }

    /**
     * Cria na página uma tabela com uma linha de titulos
     *
     * @param pag - ficheiro página
     * @param titulos - linha de titulos
     * @param info - matriz corpo da tabela
     * @param nEls - número de linhas da matriz info
     */
    public static void criarTabelaComLinhaTitulos(Formatter pag,
            String[] titulos, String[][] info, int nEls) {
        iniciarTabela(pag);
        linhaCabecalhoTabela(pag, titulos);
        corpoTabela(pag, info, nEls);
        fecharTabela(pag);
    }

    /**
     * Cria na página uma tabela com duas linhas de titulos
     *
     * @param pag - ficheiro página
     * @param titulos1 - 1ª linha de titulos
     * @param titulos2 - 2ª linha de titulos
     * @param info - matriz corpo da tabela
     * @param nEls - número de linhas da matriz info
     */
    public static void criarTabelaComDuasLinhasTitulos(Formatter pag,
            String[] titulos1, String[] titulos2, String[][] info, int nEls) {

        iniciarTabela(pag);
        linhaCabecalhoTabela(pag, titulos1);
        linhaCabecalhoTabela(pag, titulos2);
        corpoTabela(pag, info, nEls);
        fecharTabela(pag);
    }

}
