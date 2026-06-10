public class TestListaDupla {
    public static void main(String[] args) {
        ListaDupla lista = new ListaDupla();

        Livro l1 = new Livro("0", "Livro A", "Autor A", 2000);
        Livro l2 = new Livro("1", "Livro B", "Autor B", 2001);
        Livro l3 = new Livro("2", "Livro C", "Autor C", 2002);

        lista.insereInicio(l1);
        lista.insereFim(l2);
        lista.insereInicio(l3);

        System.out.println("Listar do inicio:");
        lista.listarDoInicio();

        System.out.println("Listar do fim:");
        lista.listarDoFim();

        System.out.println("Buscar por ISBN 1: " + lista.buscarPorIsbn("1"));

        System.out.println("Tamanho: " + lista.tamanho());

        System.out.println("Remover primeiro: " + lista.removePrimeiro());
        System.out.println("Remover ultimo: " + lista.removeUltimo());

        System.out.println("Listar apos remocoes:");
        lista.listarDoInicio();

        System.out.println("Tamanho final: " + lista.tamanho());
    }
}
