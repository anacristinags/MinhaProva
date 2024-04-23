import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        //Arraylist
        ArrayList<Jogador> participantes = new ArrayList<>();
        participantes.add(new Jogador("Alane Dias"));
        participantes.add(new Jogador("Beatriz Reis"));
        participantes.add(new Jogador("Davi Brito"));
        participantes.add(new Jogador("Deniziane Ferreia"));
        participantes.add(new Jogador("Fernanda Bande"));
        participantes.add(new Jogador("Giovanna Lima"));
        participantes.add(new Jogador("Giovanna Pitel"));
        participantes.add(new Jogador("Isabelle Nogueira"));
        participantes.add(new Jogador("Juninho"));
        participantes.add(new Jogador("Leidy Elin"));
        participantes.add(new Jogador("Lucas Henrique"));
        participantes.add(new Jogador("Lucas Luigi"));
        participantes.add(new Jogador("Lucas Pizane"));
        participantes.add(new Jogador("Marcus Vinicius"));
        participantes.add(new Jogador("Matteus Amaral"));
        participantes.add(new Jogador("Maycon Cosmer"));
        participantes.add(new Jogador("MC Bin Laden"));
        participantes.add(new Jogador("Michel Nogueira"));
        participantes.add(new Jogador("Nizam"));
        participantes.add(new Jogador("Raquele Cardozo"));
        participantes.add(new Jogador("Rodriguinho"));
        participantes.add(new Jogador("Thalyta Alves"));
        participantes.add(new Jogador("Vanessa Lopes"));
        participantes.add(new Jogador("Vinicius Rodrigues"));
        participantes.add(new Jogador("Wanessa Camargo"));
        participantes.add(new Jogador("Yasmin Brunet"));

        Scanner scanner = new Scanner(System.in);
        int escolha = 0;
        do {
            try{
                System.out.println("\nVotação BBB");
                System.out.println("Escolha uma opcção");
                System.out.println("1) Votar no participante para eliminar");
                System.out.println("2) Para saber o resultado da votação");
                System.out.println("3) Para para encerrar o programa");
                escolha = scanner.nextInt();

                if (escolha > 3 || escolha < 1){
                    throw new InputMismatchException();
                }

                switch (escolha){
                    case 1:
                        votar(participantes);
                        break;
                    case 2:
                        resultado(participantes);
                        break;
                }

            } catch (InputMismatchException e){
                System.err.println("Digite um número entre 1 e 3");
                scanner.nextLine();
            }

        } while (escolha != 3);

    }

    //metodo para votar
    private static void votar(ArrayList<Jogador> participantes){
        String nomeVoto = "";
        Scanner voto = new Scanner(System.in);
        boolean participanteON = false;
        System.out.println("Em quem você vota para sair da casa?");
        nomeVoto  = voto.nextLine();
        for (Jogador p1 : participantes){
            if (p1.getNome().equalsIgnoreCase(nomeVoto)){
                p1.incrementaUmVoto();
                participanteON = true;
            }
        }
        if(participanteON == true){
            System.out.println("Voto contabilizado");
        } else {
            System.err.println("Digite o nome válido");
        }

    }

    //metodo para listar votos
    private static void resultado(ArrayList<Jogador> participantes){
        Jogador maxVotos = null;
        for (Jogador p1 : participantes){
            if (maxVotos == null || p1.getVoto()>maxVotos.getVoto()){
                maxVotos =p1;
            }
        }
        if (maxVotos.getVoto()>0){
            System.out.println("Se eu conseguir mover montanhas, se eu conseguir surfar um tsunami, se eu conseguir\n" +
                    "domar o sol, se eu conseguir fazer o mar virar sertão, e o sertão virar mar, se eu\n" +
                    "conseguir dizer o que eu nunca vou conseguir dizer, aí terá chegado o dia em que eu\n" +
                    "vou conseguir te eliminar com alegria. Com " + maxVotos.getVoto() + " votos, é você quem sai "+
                    maxVotos.getNome());
        } else {
            System.err.println("Ninguém recebeu voto");
        }
    }

}
