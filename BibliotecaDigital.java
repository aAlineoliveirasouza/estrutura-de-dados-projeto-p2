import java.util.Scanner;

public class BibliotecaDigital {
    private static Catalogo catalogo = new Catalogo();
    private static ListaDupla acervo = new ListaDupla();
    private static GestorEmprestimos gestor = new GestorEmprestimos(catalogo);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Biblioteca Digital ---");
            System.out.println("1. Cadastrar livro");
            System.out.println("2. Buscar livro por ISBN");
            System.out.println("3. Listar acervo do inicio ao fim");
            System.out.println("4. Listar acervo do fim ao inicio");
            System.out.println("5. Solicitar emprestimo");
            System.out.println("6. Devolver livro");
            System.out.println("7. Ver fila de espera");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            String op = sc.nextLine().trim();
            if (op.equals("0"))
                break;
            switch (op) {
                case "1":
                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();
                    System.out.print("Titulo: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    System.out.print("Ano publicacao: ");
                    int ano = Integer.parseInt(sc.nextLine());
                    Livro l = new Livro(isbn, titulo, autor, ano);
                    acervo.insereFim(l);
                    catalogo.cadastrar(l);
                    System.out.println("Livro cadastrado.");
                    break;
                case "2":
                    System.out.print("ISBN: ");
                    isbn = sc.nextLine();
                    Livro r = catalogo.buscar(isbn);
                    System.out.println(r == null ? "Nao encontrado" : r);
                    break;
                case "3":
                    acervo.listarDoInicio();
                    break;
                case "4":
                    acervo.listarDoFim();
                    break;
                case "5":
                    System.out.print("Matricula: ");
                    int mat = Integer.parseInt(sc.nextLine());
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("ISBN do livro: ");
                    isbn = sc.nextLine();
                    Usuario u = new Usuario(mat, nome, email);
                    gestor.solicitarEmprestimo(isbn, u);
                    break;
                case "6":
                    System.out.print("ISBN: ");
                    isbn = sc.nextLine();
                    gestor.devolverLivro(isbn);
                    break;
                case "7":
                    System.out.print("ISBN: ");
                    isbn = sc.nextLine();
                    gestor.listarFilaDeEspera(isbn);
                    break;
                default:
                    System.out.println("Opcao invalida");
            }
        }
        sc.close();
    }

}
