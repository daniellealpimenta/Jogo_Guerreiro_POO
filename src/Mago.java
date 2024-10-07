import java.util.Random;
import java.util.Scanner;

class Mago extends Personagem {
    private int mana;

    public Mago(String nome, String arma) {
        super(nome, 80, 10, arma);
        this.mana = 80;
    }

    @Override
    public void atacar(Personagem inimigo) {
        Random random = new Random();
        Scanner ler = new Scanner(System.in);
        int escolha;
        boolean rodando = true;

        while (rodando){
            int dano = random.nextInt(this.forca);
            System.out.println("\n" + inimigo.nome + " tem: " + inimigo.vida + " de vida");
            System.out.println("\n" + this.nome + " tem: " + this.vida + " de vida");
            System.out.println("""
                    
                    ------ Escolha ------
                    
                    [1] - Atacar
                    [2] - Recuperar Mana
                    [3] - Lançar Magia Forte
                    
                    """);
            escolha = ler.nextInt();
            if (escolha == 1){
                if (this.mana >= 15){
                    this.mana -= 15;
                    System.out.println("O mago " + this.nome + " se concentrou e lançou uma magia no " + inimigo.nome + " causando " + dano + " de dano, e agora tem: " + this.mana + " de mana");
                    inimigo.receberDano(dano);
                    rodando = false;
                } else{
                    System.out.println(this.nome + " não tem mana suficiente para lançar magia.");
                    System.out.println(this.nome + " tem: " + this.mana + " de mana");
                    rodando = false;
                }
            } else if (escolha == 2){
                recuperarMana();
                rodando = false;
            } else {
                lancarMagia(inimigo);
                inimigo.receberDano(dano);
                rodando = false;
            }
        }
    }

    @Override
    void atacarAutomaticamente(Personagem inimigo) {
        Random random = new Random();

        if (this.mana > 15 && this.mana < 30){
            int escolha = random.nextInt(2);
            if (escolha == 0){
                this.mana -= 15;
                int dano = random.nextInt(this.forca);
                inimigo.receberDano(dano);
                System.out.println("\nO mago " + this.nome + " se concentrou e lançou uma magia no " + inimigo.nome + " causando " + dano + " de dano, e agora tem: " + this.mana + " de mana");
            } else {
                recuperarMana();
            }
        }
        else if (this.mana > 15) {
            int escolha = random.nextInt(2);
            if (escolha == 0){
                this.mana -= 15;
                int dano = random.nextInt(this.forca);
                inimigo.receberDano(dano);
                System.out.println("\nO mago " + this.nome + " se concentrou e lançou uma magia no " + inimigo.nome + " causando " + dano + " de dano, e agora tem: " + this.mana + " de mana");
            } else {
                this.mana -= 30;
                int dano = random.nextInt(21) + 15;
                inimigo.receberDano(dano);
                System.out.println("\n" + this.nome + " juntou todas as suas forças e envolvendo seu(sua) "+ arma +" de mana, lançou uma magia poderosa que causou: " + dano + " de dano em " + inimigo.nome + "!");
                System.out.println(this.nome + " agora tem " + this.mana + " de mana restante.");
            }

        } else {
            recuperarMana();
        }
    }

    public void recuperarMana(){
        Random random = new Random();
        int recuperar = random.nextInt(16) + 15;
        this.mana += recuperar;
        System.out.println("O Mago "+ this.nome + " começou a meditar e recuperou a sua mana e agora tem: " + this.mana);
    }

    public void lancarMagia(Personagem inimigo) {
        if (this.mana >= 30) {
            this.mana -= 30;
            Random random = new Random();
            int dano = random.nextInt(21) + 25; // Dano entre 20 e 45
            inimigo.receberDano(dano);
            System.out.println(this.nome + " juntou todas as suas forças e recitou as palavras do seu livro mágico, lançando uma magia poderosa que causou: " + dano + " de dano em " + inimigo.nome + "!");
            System.out.println(this.nome + " agora tem " + this.mana + " de mana restante.");
        } else {
            System.out.println(this.nome + " não tem mana suficiente para lançar magia.");
            System.out.println(this.nome + " tem: " + this.mana + " de mana");
        }
    }
}
