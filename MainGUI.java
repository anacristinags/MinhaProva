import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainGUI extends JFrame {
    ArrayList<Jogador> participantes = new ArrayList<>();

    JPanel painel = new JPanel();
    JLabel mensagem = new JLabel("Votação BBB");
    JButton bt1 = new JButton("Votar");
    JButton bt2 = new JButton("Resultado");
    JButton bt3 = new JButton("Sair");

    //construtor
    public MainGUI(){
        this.setTitle("Menu BBB");
        this.setSize(250,200);
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 15));

        this.add(painel);
        painel.add(mensagem);
        painel.add(bt1);
        painel.add(bt2);
        painel.add(bt3);

        //cadastrar participantes
        cadastrarJogadores();

        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                votacao();
            }
        });

        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultado();
            }
        });

        bt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        this.getContentPane().add(painel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public void votacao(){
        String nomeVotado = JOptionPane.showInputDialog(null, "Em quem você vota para sair da casa?");
        boolean participanteON = false;
        for (Jogador p1 : participantes){
            if (p1.getNome().equalsIgnoreCase(nomeVotado)){
                p1.incrementaUmVoto();
                participanteON = true;
                JOptionPane.showMessageDialog(null, "Voto contabilizado!",
                        "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                break;
            }
        }

        if(!participanteON){
            JOptionPane.showMessageDialog(null, "Digite um nome valido",
                    "Erro, voto não contabilizado", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void resultado(){
        Jogador maxVotos = null;
        for (Jogador p1 : participantes){
            if (maxVotos == null || p1.getVoto()>maxVotos.getVoto()){
                maxVotos =p1;
            }
        }
        if (maxVotos.getVoto()>0){
            JOptionPane.showMessageDialog(null, "Se eu conseguir mover montanhas, se eu conseguir surfar um tsunami, se eu conseguir\n" +
                    "domar o sol, se eu conseguir fazer o mar virar sertão, e o sertão virar mar, se eu\n" +
                    "conseguir dizer o que eu nunca vou conseguir dizer, aí terá chegado o dia em que eu\n" +
                    "vou conseguir te eliminar com alegria. Com " + maxVotos.getVoto() + " votos, é você quem sai "+
                    maxVotos.getNome(), "Resultado", JOptionPane.PLAIN_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "Ninguém recebeu voto",
                    "Votos Vazios",JOptionPane.INFORMATION_MESSAGE);
        }
    }


    //arrays
    public void cadastrarJogadores(){
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
    }

    public static void main(String[] args) {
        new MainGUI();
    }
}
