public class TestGestorEmprestimos {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();
        Livro livro = new Livro("1", "Algoritmos", "Autor X", 2020);
        catalogo.cadastrar(livro);

        GestorEmprestimos gestor = new GestorEmprestimos(catalogo);
        Usuario u1 = new Usuario(1, "Juan", "email@example.com");
        Usuario u2 = new Usuario(2, "Nicole", "email@example.com");

        System.out.println("Estado inicial: " + catalogo.buscar("1"));

        System.out.println("\n-- Solicitar emprestimo para Juan(disponivel)");
        gestor.solicitarEmprestimo("1", u1);
        System.out.println("Estado apos emprestimo para Juan: " + catalogo.buscar("1"));

        System.out.println("\n-- Solicitar emprestimo para Nicole (deve entrar na fila)");
        gestor.solicitarEmprestimo("1", u2);
        System.out.println("Fila de espera atual:");
        gestor.listarFilaDeEspera("1");

        System.out.println("\n-- Devolver livro (deve atender Nicole automaticamente)");
        gestor.devolverLivro("1");
        System.out.println("Estado apos devolucao (emprestado a u2): " + catalogo.buscar("1"));
        System.out.println("Fila de espera apos atendimento:");
        gestor.listarFilaDeEspera("1");

        System.out.println("\n-- Devolver novamente (fila vazia, livro fica disponivel)");
        gestor.devolverLivro("1");
        System.out.println("Estado final: " + catalogo.buscar("1"));
    }
}
