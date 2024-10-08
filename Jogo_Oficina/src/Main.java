public class Main {
    public static void main(String[] args) {
        JogoBatalha batalha = new JogoBatalha();

        Personagem guerreiro = new Guerreiro("Ariel", "Tridente");
        Personagem mago = new Mago("Melody", "Pau de Self");

        batalha.batalha(mago, guerreiro);
    }
}
