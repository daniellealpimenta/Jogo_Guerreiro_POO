public class JogoBatalha {
    public static void batalha(Personagem personagem1, Personagem personagem2) {
        System.out.println("\nBatalha entre " + personagem1.nome + " e " + personagem2.nome + " começou!");
        System.out.print("-".repeat(50));

        while (personagem1.estaVivo() && personagem2.estaVivo()) {
            personagem1.atacar(personagem2);
            if (personagem2.estaVivo()) {
                personagem2.atacarAutomaticamente(personagem1);
            }
            System.out.println();
        }

        if (personagem1.estaVivo()) {
            System.out.println(personagem1.nome + " venceu a batalha!");
        } else {
            System.out.println(personagem2.nome + " venceu a batalha!");
        }
    }
}