import java.util.Scanner;
public class ContaBanco {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("BEM VINDO AO BANCO DO ARTHUR, O BANCO MAIS SEGURO DO BRASIL");
        System.out.println("---------------------------------------------------------");
        System.out.println("Digite o número da agência: ");
        int numConta = sc.nextInt();
        System.out.println("Digite o nome da agência: ");
        String nomeAgencia = sc.next();
        System.out.println("Digite o seu nome: ");
        String nomeCliente = sc.next();
        System.out.println("Digite o saldo da sua conta: ");
        double saldo = sc.nextDouble();
        System.out.println("\"Olá "+ nomeCliente +", obrigado por criar uma conta em nosso banco, sua agência é " + nomeAgencia + ", conta "+ numConta +" e seu saldo R$ "+ saldo + " já está disponível para saque.");


    }
}
