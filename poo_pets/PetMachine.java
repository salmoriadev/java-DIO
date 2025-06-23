public class PetMachine {

    private static final int MAX_WATER = 30;
    private static final int MAX_SHAMPOO = 10;
    private static final int WATER_PER_SHOWER = 10;
    private static final int SHAMPOO_PER_SHOWER = 2;
    private static final int WATER_PER_CLEANING = 5;
    private static final int SHAMPOO_PER_CLEANING = 1;

    private boolean isMachineClean;
    private int water;
    private int shampoo;
    private Pet currentPet;


    public PetMachine() {
        this.water = MAX_WATER;
        this.shampoo = MAX_SHAMPOO;
        this.isMachineClean = true;
        this.currentPet = null;
    }

    public void takeShower() {
        if (this.currentPet == null) {
            System.out.println("Erro: Não há nenhum pet na máquina para dar banho.");
            return;
        }

        if (!this.isMachineClean) {
            System.out.println("Erro: A máquina está suja. Limpe-a antes de dar outro banho.");
            return;
        }

        if (this.water < WATER_PER_SHOWER) {
            System.out.println("Erro: Pouca água na máquina para dar banho. Abasteça a água.");
            return;
        }

        if (this.shampoo < SHAMPOO_PER_SHOWER) {
            System.out.println("Erro: Pouco shampoo na máquina para dar banho. Abasteça o shampoo.");
            return;
        }

        this.water -= WATER_PER_SHOWER;
        this.shampoo -= SHAMPOO_PER_SHOWER;
        this.currentPet.setClean(true);
        this.isMachineClean = false;
        System.out.println("Sucesso: O pet " + this.currentPet.getName() + " tomou banho e está limpo!");
    }

    public void addWater() {
        if (water == MAX_WATER) {
            System.out.println("Aviso: Já temos o máximo de água (" + MAX_WATER + " unidades).");
            return;
        }
        water = Math.min(water + 2, MAX_WATER); // Adiciona água, limitando ao máximo
        System.out.println("Sucesso: Água abastecida. Nível atual: " + water + " unidades.");
    }

    public void addShampoo() {
        if (shampoo == MAX_SHAMPOO) {
            System.out.println("Aviso: Já temos o máximo de shampoo (" + MAX_SHAMPOO + " unidades).");
            return;
        }
        shampoo = Math.min(shampoo + 2, MAX_SHAMPOO);
        System.out.println("Sucesso: Shampoo abastecido. Nível atual: " + shampoo + " unidades.");
    }

    public int getWater() {
        return water;
    }

    public int getShampoo() {
        return shampoo;
    }

    public boolean hasPet() {
        return currentPet != null;
    }

    public Pet getCurrentPet() {
        return currentPet;
    }

    public void setPet(Pet pet) {
        if (this.currentPet != null) {
            System.out.println("Aviso: O pet " + this.currentPet.getName() + " já está na máquina. Remova-o antes de adicionar outro.");
            return;
        }
        if (!this.isMachineClean) {
            System.out.println("Aviso: A máquina está suja. Não é possível colocar um novo pet antes de limpá-la.");
            return;
        }
        this.currentPet = pet;
        System.out.println("Sucesso: O pet " + pet.getName() + " foi colocado na máquina.");
    }

    public void removePet() {
        if (this.currentPet == null) {
            System.out.println("Erro: Não há nenhum pet na máquina para remover.");
            return;
        }
        System.out.println("Sucesso: O pet " + this.currentPet.getName() + " foi removido da máquina.");
        this.currentPet = null; // Remove o pet
    }

    public void cleanMachine() {
        if (this.water < WATER_PER_CLEANING) {
            System.out.println("Erro: Pouca água para limpar a máquina. Abasteça a água.");
            return;
        }
        if (this.shampoo < SHAMPOO_PER_CLEANING) {
            System.out.println("Erro: Pouco shampoo para limpar a máquina. Abasteça o shampoo.");
            return;
        }

        if (this.isMachineClean) {
            System.out.println("Aviso: A máquina já está limpa.");
            return;
        }

        this.water -= WATER_PER_CLEANING;
        this.shampoo -= SHAMPOO_PER_CLEANING;
        this.isMachineClean = true;
        System.out.println("Sucesso: A máquina foi limpa.");
    }

    public boolean isMachineClean() {
        return isMachineClean;
    }
}