import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PetMachine petMachine = new PetMachine(); // Cria uma instância da PetMachine

        int option;
        do {
            System.out.println("\n--- Menu da Máquina de Banho de Pets ---");
            System.out.println("1 - Dar banho no pet");
            System.out.println("2 - Abastecer água na máquina");
            System.out.println("3 - Abastecer shampoo na máquina");
            System.out.println("4 - Ver nível de água da máquina");
            System.out.println("5 - Ver nível de shampoo da máquina");
            System.out.println("6 - Ver se tem pet na máquina");
            System.out.println("7 - Colocar um pet na máquina");
            System.out.println("8 - Tirar o pet da máquina");
            System.out.println("9 - Limpar a máquina");
            System.out.println("0 - Sair");
            System.out.print("Escolha a opção desejada: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    petMachine.takeShower();
                    break;
                case 2:
                    petMachine.addWater();
                    break;
                case 3:
                    petMachine.addShampoo();
                    break;
                case 4:
                    System.out.println("Nível de água atual: " + petMachine.getWater() + " unidades.");
                    break;
                case 5:
                    System.out.println("Nível de shampoo atual: " + petMachine.getShampoo() + " unidades.");
                    break;
                case 6:
                    if (petMachine.hasPet()) {
                        System.out.println("Sim, o pet " + petMachine.getCurrentPet().getName() + " está na máquina.");
                        System.out.println("Ele está limpo? " + (petMachine.getCurrentPet().isClean() ? "Sim" : "Não"));
                    } else {
                        System.out.println("Não há nenhum pet na máquina.");
                    }
                    break;
                case 7:
                    System.out.print("Digite o nome do pet: ");
                    String petName = scanner.nextLine();
                    Pet newPet = new Pet(petName);
                    petMachine.setPet(newPet);
                    break;
                case 8:
                    petMachine.removePet();
                    break;
                case 9:
                    petMachine.cleanMachine();
                    break;
                case 0:
                    System.out.println("Saindo do programa. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção entre 0 e 9.");
                    break;
            }

        } while (option != 0);

        scanner.close();
    }
}