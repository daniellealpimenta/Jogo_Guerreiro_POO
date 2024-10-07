import java.security.cert.TrustAnchor;
import java.util.Random;
import java.util.Scanner;

class Guerreiro extends Personagem {
    private int stamina;

    public Guerreiro(String nome, String arma) {
        super(nome, 120, 15, arma);
        this.stamina = 50;
    }

    @Override
    public void atacar(Personagem inimigo) {
        Random random = new Random();
        Scanner ler = new Scanner(System.in);
        int escolha;
        boolean rodando = true;

        while (rodando) {
            int dano = random.nextInt(this.forca);
            System.out.println("\n" + inimigo.nome + " tem: " + inimigo.vida + " de vida");
            System.out.println("\n" + this.nome + " tem: " + this.vida + " de vida");
            System.out.println("""
                    
                    ------ Escolha ------
                    
                    [1] - Atacar
                    [2] - Recuperar Stamina
                    [3] - Ataque Especial
                    
                    """);
            escolha = ler.nextInt();
            if (escolha == 1){
                if (this.stamina >= 10){
                    this.stamina -= 10;
                    System.out.print("O guerreiro "+ this.nome + " usou sua espada, atacou e causou: " + dano + " de dano, no "+ inimigo.nome +" e agora tem: " + this.stamina + " de stamina");
                    inimigo.receberDano(dano);
                    rodando = false;
                }else{
                    System.out.println(this.nome + " não tem Stamina o suficiente para usar esse ataque!");
                    System.out.println(this.nome + " tem: " + this.stamina + " de stamina");
                    rodando = false;
                }
            } else if (escolha == 2){
                recuperarStamina();
                rodando = false;
            } else {
                ataqueEspecial(inimigo);
                inimigo.receberDano(dano);
                rodando = false;
            }
        }

    }

    @Override
    void atacarAutomaticamente(Personagem inimigo) {
        Random random = new Random();

        if (this.stamina > 10 && this.stamina < 25){
            int escolha = random.nextInt(2);
            if (escolha == 0){
                this.stamina -= 10;
                int dano = random.nextInt(this.forca);
                inimigo.receberDano(dano);
                System.out.print("\nO guerreiro "+ this.nome + " usou sua espada, atacou e causou: " + dano + " de dano, no "+ inimigo.nome +" e agora tem: " + this.stamina + " de stamina");
            } else {
                recuperarStamina();
            }
        }
        else if (this.stamina > 10) {
            int escolha = random.nextInt(2);
            if (escolha == 0){
                this.stamina -= 10;
                int dano = random.nextInt(this.forca);
                inimigo.receberDano(dano);
                System.out.print("\nO guerreiro "+ this.nome + " usou sua espada, atacou e causou: " + dano + " de dano, no "+ inimigo.nome +" e agora tem: " + this.stamina + " de stamina");
            } else {
                this.stamina -= 25;
                int dano = random.nextInt(21) + 15;
                inimigo.receberDano(dano);
                System.out.println("\n" + this.nome + " jogou um escudo na cabeça do " + inimigo.nome + " e o acertou usando seu(sua) " + this.arma + ", causando: " + dano + " de dano em " + inimigo.nome + "!");
                System.out.println(this.nome + " agora tem: " + this.stamina + " de stamina");
            }

        } else {
            recuperarStamina();
        }
    }

    public void recuperarStamina(){
        Random random = new Random();
        int recuperar = random.nextInt(11) + 10;
        this.stamina += recuperar;
        System.out.println("O guerreiro " + this.nome + " se sentou para descansar e recuperou a sua stamina e agora tem: " + this.stamina);
    }

    public void ataqueEspecial(Personagem inimigo) {
        if (this.stamina >= 25){
            this.stamina -= 25;
            Random random = new Random();
            int dano = random.nextInt(21) + 15; // Dano entre 20 e 35
            inimigo.receberDano(dano);
            System.out.println(this.nome + " jogou um escudo na cabeça do " + inimigo.nome + " e o acertou usando seu(sua) " + this.arma + ", causando: " + dano + " de dano em " + inimigo.nome + "!");
            System.out.println(this.nome + " agora tem: " + this.stamina + " de stamina");
        } else{
            System.out.println(this.nome + " não tem Stamina o suficiente para usar esse ataque!");
            System.out.println(this.nome + " tem: " + this.stamina + " de stamina");
        }
    }
}
