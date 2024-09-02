package desafioToDo;
import java.util.ArrayList;
import java.util.Scanner;

public class todo {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        do {
            String userPrompt;
            System.out.println("[1] Adicione uma tarefa! ");
            System.out.println("[2] Marcar tarefa como concluída! ");
            System.out.println("[3] Remover tarefa! ");
            System.out.println("[4] Ver lista!");
            System.out.println("[5] Sair! \n");

            System.out.println("O que você deseja?");
            userPrompt = user.nextLine();

            //casos
            switch (userPrompt) {
                case "1":
                    System.out.println("Qual tarefa deseja adicionar?");
                    String Adicionar = user.nextLine();
                    list.add(Adicionar);
                    System.out.println("Tarefa adicionada com sucesso! \n");
                    break;
                case "2":
                    System.out.println("Qual tarefa deseja marcar como concluída?");
                    String Marcar = user.nextLine();
                    int index = list.indexOf(Marcar);
                    if (index != -1){
                        list.set(index, Marcar + "#");
                        System.out.println("Tarefa concluída!!");

                    } else {
                        System.out.println("Tarefa não existe!");
                    }
                    break;
                case "3":
                    System.out.println("Qual tarefa você deseja remover?");
                    String Remover = user.nextLine();
                    if(list.contains(Remover)){
                        list.remove(Remover);
                        System.out.println("Item removido com sucesso!");
                    } else {
                        System.out.println("Tarefa não encontrada!");
                    }
                    break;
                case "4" :
                    for (String task : list){
                        System.out.println("-> " + task);
                    }
                    break;
                case "5":
                    System.out.println("Tem certeza que deseja sair? (s/n) ");
                    String Sair = user.nextLine();
                    if (Sair.equalsIgnoreCase("s")){
                        System.out.println("Até logo...");
                        System.exit(1);
                        break;
                    } else{
                        continue;
                    }
                default:
                    System.out.println("ERROR");
                    break;
            }
        }while (true) ;
    }
}
