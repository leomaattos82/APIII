import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.xml.bind.SchemaOutputResolver;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by leomattos on 26/09/2016.
 */
public class Principal {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);

        ArrayList<Canil> cadastro = new ArrayList<Canil>();
        int op=0;
        int op1=0;
        int quant_f=0;
        int quant_m=0;
        int prem=0;

        do {
            System.out.println(" 1 - Adicionar um Cachorro");
            System.out.println(" 2 - Listar um Cachorro");
            System.out.println(" 3 - Remover um Cachorro");
            System.out.println(" 0 - fechar o programa");
            System.out.println(" ");
            System.out.println("Numero de cachorros cadastrados: "+ cadastro.size());
            for(int i=0; i<cadastro.size(); i++){
                if((cadastro.get(i).getSexo()=='f')||(cadastro.get(i).getSexo()=='F')){
                    quant_f++;
                }
            }

            System.out.println("Numero de cadelas cadastradas: "+ quant_f);
            for(int i=0; i<cadastro.size(); i++){
                if((cadastro.get(i).getSexo()=='m')||(cadastro.get(i).getSexo()=='M')){
                    quant_m++;
                }
            }

            quant_m=cadastro.size()-quant_f;
            System.out.println("Numero de câes cadastradas: "+ quant_m);

            System.out.println("Total de premiações: "+ prem);
            for(int i=0;i<cadastro.size();i++){
                if (cadastro.get(i).getPremios()== 'S' || cadastro.get(i).getPremios()== 's'){
                    prem++;
                }else{
                    prem=0;
                }

            }
            System.out.println("digite a opção");
            op=tc.nextInt();


            switch (op){

                case 1:{
                    String nome;
                    System.out.println("Informe o nome do cachorro: ");
                    nome=tc.nextLine();
                    Canil c1 = new Canil(nome);
                    if (cadastro.contains(c1)){
                        System.out.println("Animal ja cadastrado!");
                    }else{

                        c1.cadastro();
                        cadastro.add(c1);
                    }
                    break;
                }

                case 2:{
                    System.out.println("Listar");
                    System.out.println("1- Raca");
                    System.out.println("2- nome semelhante");
                    System.out.println("3- pedigree");
                    op1=tc.nextInt();
                    if (op1==1){
                        String raca;
                        System.out.println("Informe a raca: ");
                        raca=tc.nextLine();
                        for (int i = 0; i<cadastro.size();i++) {
                            if (cadastro.get(i).getRaca().equals(raca)) {
                                System.out.println(cadastro.get(i).toString());
                            } else {
                                System.out.println("Nome nao enocntrado.");
                            }
                        }

                    }else if(op1==2){
                        String nome;
                        System.out.println("Informe o nome do cachorro: ");
                        nome=tc.nextLine();
                        Canil c2 = new Canil(nome);
                        for (int i=0;i<cadastro.size();i++){
                            if (c2.compara(cadastro.get(i).getNome())){
                                System.out.println(cadastro.toString());
                            }else{
                                System.out.println("Cachorro nao encontrado.");
                            }

                        }
                    }else
                    {
                        for (int i=0;i<cadastro.size();i++){
                            if (cadastro.get(i).getPedigree()==('s') || cadastro.get(i).getPedigree() == ('S')){
                                System.out.println(cadastro.get(i).toString());
                            }
                            else{
                                System.out.println("Cachorro com pedigree nao encontrado");
                            }

                        }

                    }
                    break;
                }

                case 3: {
                    System.out.println("Remover cachorro:");
                    System.out.println("1 - nome semelhante:");
                    System.out.println("2 - Remover nome iguais:");
                    System.out.println("3 - Remover pedigree:");
                    op1=tc.nextInt();
                    if (op1==1){
                        String nome;
                        System.out.println("informe o nome do cachorro:");
                        nome=tc.nextLine();
                        Canil c1 = new Canil(nome);
                        for (int i=0;i<cadastro.size();i++){
                            if (c1.compara(cadastro.get(i).getNome())){
                                cadastro.remove(i);
                                System.out.println("removido com sucesso");
                            }

                        }
                    }
                    else if (op1==2){
                        String nome;
                        System.out.println("Informe o nome do cahorro");
                        nome=tc.nextLine();
                        Canil c1 = new Canil(nome);
                        if (cadastro.contains(c1)){
                            int p = cadastro.indexOf(c1);
                            cadastro.remove(p);
                            System.out.println("removido com sucesso.");
                        }else{
                            System.out.println("Cadastro nao foi encontrado");
                        }

                    }
                    else{
                        for (int i=0;i<cadastro.size();i++){
                            if (cadastro.get(i).getPedigree()==('s') || cadastro.get(i).getPedigree() == ('S')){
                                cadastro.remove(i);
                                System.out.println("removido com sucesso.");
                            }

                            else{
                                System.out.println("Cachorro com pedigree nao encontrado");
                            }

                        }

                    }

                    break;
                }

                case 0:{
                    System.out.println("fechando programa.");
                    break;
                }



            }






        }while(op!=0);






    }



}
