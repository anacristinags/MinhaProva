public class Jogador {
    String nome;
    int voto;

    //construtor
    public Jogador(String nome) {
        this.nome = nome;
    }

    // metodo
    public void incrementaUmVoto(){
        this.voto++;
    }

    //getters
    public String getNome() {return nome;}

    public int getVoto() {return voto;}

    //setters
    public void setNome(String nome) {this.nome = nome;}

    public void setVoto(int voto) {this.voto = voto;}
}
