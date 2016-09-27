import java.util.Scanner;

/**
 * Created by leomattos on 26/09/2016.
 */
public class Canil {

    Scanner tc = new Scanner(System.in);

    private String nome;
    private String raca;
    private int idade;
    private char sexo;
    private char pedigree;
    private char premios;



    public Canil(String nome){
        while(nome.length() < 2){
            System.out.println("nome invalido!");
            System.out.println("Digite novamente: ");
            nome=tc.nextLine();
        }

        this.setNome(nome);
    }

    public void cadastro(){
        System.out.println("Informe raca: ");
        this.setRaca(tc.nextLine());
        System.out.println("Informe idade: ");
        this.setIdade(tc.nextInt());
        System.out.println("Informe sexo: F/M ");
        this.setSexo(tc.next().charAt(0));
        System.out.println("Informe pedigree: S/N ");
        this.setPedigree(tc.next().charAt(0));
        System.out.println("Informe premios: S/N ");
        this.setPremios(tc.next().charAt(0));


    }


    public String getNome(){
        return nome;
    }
    public String getRaca(){
        return raca;
    }
    public int getIdade(){
        return idade;
    }
    public char getSexo(){
        return sexo;
    }
    public char getPedigree(){
        return pedigree;
    }
    public char getPremios(){
        return premios;
    }

    public void setNome(String nome){
        this.nome=nome;
    }
    public void setRaca(String raca){
        this.raca=raca;
    }
    public void setIdade(int idade){
        this.idade=idade;
    }
    public void setSexo(char sexo){
        this.sexo=sexo;
        while((sexo)!='f' && (sexo)!= 'F' && (sexo)!= 'M' && (sexo)!= 'm'){
            System.out.println("Operação recusada");
            System.out.println("Digite M ou F");
            sexo=tc.next().charAt(0);
        }
        this.sexo=sexo;
    }


    public void setPedigree(char pedigree){
        this.pedigree=pedigree;
        while((pedigree)!= 'S' && (pedigree)!= 's' && (pedigree)!= 'N' && (pedigree)!= 'n'){
            System.out.println("Operação recusada");
            System.out.println("Digite S ou N");
        }
        this.pedigree=pedigree;
    }
    public void setPremios(char premios){
        this.premios=premios;

        while((premios)!= 'S' && (premios)!= 's' && (premios)!= 'N' && (premios)!= 'n'){
            System.out.println("Operação recusada");
            System.out.println("Digite S ou N");
        }
        this.premios=premios;
    }

    public boolean compara(String nome){
        if(nome.length()<4){
            System.out.println("Numero insuficiente de caracteres");
            return false;
        }else {
            if (nome.substring(0, 4).equals(this.nome.substring(0,4))){
                System.out.println("Nomes parecidos");
            }
            return true;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Canil other = (Canil) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + "Raça" + this.raca + "Idade: " + this.idade + "Sexo: " + this.sexo + "Pedigree: " + this.pedigree + "Prêmios: " + this.premios + "";
    }






}
