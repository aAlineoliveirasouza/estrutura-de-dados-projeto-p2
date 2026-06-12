public class GestorEmprestimos {
    private NossoHash<String, Fila<Usuario>> filas = new NossoHash<>();
    private Catalogo catalogo;
    // Não foi especificado qual era a classe que ficaria aqui, então optei por
    // catalogo por ser O(1) em buscas

    public GestorEmprestimos(Catalogo catalogo) {
        this.catalogo = catalogo;// Compartilha o catalogo assim se mudar algo gestor emprestimo tbm notara, ou
                                 // mudara
    }

    public void solicitarEmprestimo(String isbn, Usuario u) {
        Livro l = catalogo.buscar(isbn);
        if (l == null) {
            System.out.println("Livro nao encontrado: " + isbn);
            return;
        }
        if (l.isDisponivel()) {
            l.setDisponivel(false);
            System.out.println("Emprestado: " + l + " para " + u);
        } else {
            Fila<Usuario> f = filas.get(isbn);
            if (f == null) {
                f = new Fila<>();
                filas.put(isbn, f);
            }
            f.enfileira(u);
            System.out.println("Usuario " + u + " enfileirado para " + isbn);
        }
    }

    public void devolverLivro(String isbn) {
        Livro l = catalogo.buscar(isbn);
        if (l == null) {
            System.out.println("Livro nao encontrado: " + isbn);
            return;
        }
        Fila<Usuario> f = filas.get(isbn);
        if (f != null && !f.filaVazia()) {
            Usuario proximo = f.desenfileira();
            l.setDisponivel(false);
            System.out.println("Livro " + isbn + " agora emprestado para " + proximo);
        } else {
            l.setDisponivel(true);
            System.out.println("Livro " + isbn + " devolvido e disponivel");
        }
    }

    public void listarFilaDeEspera(String isbn) {
        Fila<Usuario> f = filas.get(isbn);
        if (f == null || f.filaVazia())
            System.out.println("Fila vazia para " + isbn);
        else
            System.out.println(f);
    }
}
