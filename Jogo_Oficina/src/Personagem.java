import java.util.Random;

abstract class Personagem {
    protected String nome;
    protected int vida;
    protected int forca;
    protected String arma;

    public Personagem(String nome, int vida, int forca, String arma) {
        this.nome = nome;
        this.vida = vida;
        this.forca = forca;
        this.arma = arma;
    }

    abstract void atacar(Personagem inimigo);

    abstract void atacarAutomaticamente(Personagem inimigo);

    public void receberDano(int dano) {
        if (this.vida == 0 || this.vida <= 0) {
            this.vida = 0;
            System.out.println("\n" + this.nome + " foi derrotado!");
        } else {
            this.vida -= dano;
        }
    }

    public boolean estaVivo() {
        return this.vida > 0;
    }
}
