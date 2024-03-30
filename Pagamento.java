import java.text.DecimalFormat;
import java.util.Scanner;

public class Pagamento {
    public double valorPagamento(double prestacao, int diasAtraso) {
        double multaAtraso = prestacao * 0.03;
        double multaPorDiasDeAtraso = (prestacao * 0.001) * diasAtraso;
        double total = multaAtraso + multaPorDiasDeAtraso;
        if (diasAtraso == 0) {
            return prestacao;
        } else {
            return total + prestacao;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DecimalFormat decimal = new DecimalFormat("0.00");
        double valorPrestacao = 0;
        int diasAtraso = 0;
        double resultado = 0;
        int totalPrestacoesPagas = 0;
        double valorTotalDeContas = 0.0;

        Pagamento pg = new Pagamento();

        do {
            System.out.println("Informe o valor da prestação: ");
            valorPrestacao = sc.nextDouble();
            if (valorPrestacao == 0) {
                break;
            } else {
                totalPrestacoesPagas++;

                System.out.println("Informe os dias em atraso: ");
                diasAtraso = sc.nextInt();

                resultado = pg.valorPagamento(valorPrestacao, diasAtraso);
                System.out.println("Valor total a ser pago: " + decimal.format(resultado));
                System.out.println("-------------------------------");
                valorTotalDeContas += resultado;
            }

        } while (true);

        System.out.println("-------------------------------");
        System.out.println("           RELATORIO           ");
        System.out.println("-------------------------------");
        System.out.println("Quantidade total de contas pagas: " + totalPrestacoesPagas);
        System.out.println("Valor total de contas pagas: " + decimal.format(valorTotalDeContas));

    }
}
