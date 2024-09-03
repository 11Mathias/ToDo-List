package desafioToDo;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class todo {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        do {
            String userPrompt;
            System.out.println("[1] Adicione uma tarefa! ");
            System.out.println("[2] Marcar tarefa como concluída! (#) ");
            System.out.println("[3] Remover tarefa! ");
            System.out.println("[4] Ver lista!");
            System.out.println("[5] Editar tarefa existente");
            System.out.println("[6] Salvar lista! (.txt)");
            System.out.println("[7] Sair! \n");

            System.out.println("O que você deseja?");
            userPrompt = user.nextLine();

            //casos
            switch (userPrompt) {

                //funcionalidade -> Adicionar tarefa
                case "1":
                    System.out.println("Qual tarefa deseja adicionar?");
                    String Adicionar = user.nextLine();
                    list.add(Adicionar);
                    System.out.println("Tarefa adicionada com sucesso! \n");
                    break;

                //funcionalidade -> Marcar tarefa como concluída
                case "2":
                    System.out.println("Qual tarefa deseja marcar como concluída?");
                    String Marcar = user.nextLine();
                    int index = list.indexOf(Marcar);
                    if (index != -1){
                        String tarefaMarcada = list.get(index);
                        if (tarefaMarcada.equalsIgnoreCase(" #")) {
                            System.out.println("Tarefa já está marcada como concluída!");
                        } else {
                            list.set(index, Marcar + " #");
                            System.out.println("Tarefa concluída!!");
                        }
                    } else {
                        System.out.println("Tarefa não existe!");
                    }
                    break;

                //funcionalidade -> Remover
                case "3":
                    System.out.println("Qual tarefa você deseja remover?");
                    String Remover = user.nextLine();
                    int indexRemover = list.indexOf(Remover);
                    if(indexRemover != -1) {
                        list.remove(indexRemover);
                        System.out.println("Item removido!");
                    }else {
                        for (int i = 0; i < list.size(); i++ ) {
                            String tarefa = list.get(i);
                            if(tarefa.contains(Remover + "#")) {
                                list.remove(i);
                                System.out.println("Item removido!");
                                break;
                            }
                        }
                    }
                    if (list.contains(Remover + "#")) {
                        System.out.println("Item removido!");
                    }else {
                        System.out.println("Tarefa não encontrada!");
                    }
                    break;

                //funcionalidade -> Mostrar lista
                case "4" :
                    if (list.isEmpty()){
                        System.out.println("A lista ta vazia!");
                    }else{
                        for (String task : list){
                            System.out.println("=-> " + task + " <-=");
                        }
                    }
                    break;

                //funcionalidade -> Editar tarefa
                case "5":
                    System.out.println("Qual tarefa deseja editar?");
                    String Editar = user.nextLine();
                    int indexEditar = list.indexOf(Editar);
                    if(indexEditar != -1) {
                        System.out.println("Digite a nova tarefa:");
                        String novaTarefa = user.nextLine();
                        list.set(indexEditar, novaTarefa);
                        System.out.println("Tarefa editada com sucesso!");
                    }else {
                        System.out.println("Tarefa não existe!");
                    }
                    break;

                //funcionalidades -> Salvar lista em arquivo .txt
                case "6":
                    try {
                        FileWriter arquivo = new FileWriter("tarefas.txt");
                        for(String task : list) {
                            arquivo.write(task + "\n");
                        }
                        arquivo.close();
                        System.out.println("Lista salva com sucesso!");
                    }catch (IOException e) {
                        System.out.println("Erro ao salvar lista!");
                    }
                    break;

                //funcionalidade -> Sair
                case "7":
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
