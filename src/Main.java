public class Main {
    public static void main(String[] args) {
        JogoBatalha batalha = new JogoBatalha();

        Personagem guerreiro = new Guerreiro("Hércules", "Punho");
        Personagem mago = new Mago("Gandalf", "Varinha");

        batalha.batalha(guerreiro, mago);
    }
}
