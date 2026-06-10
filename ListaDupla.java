public class ListaDupla {
    private NoDuplo pri;
    private NoDuplo ult;

    private boolean estaVazia() {
        return pri == null;
    }

    public void insereInicio(Livro livro) {
        NoDuplo temp = new NoDuplo(livro);
        if (estaVazia()) {
            ult = temp;
        } else {
            temp.setProximo(pri);
            pri.setAnterior(temp);
        }
        pri = temp;
    }

    public Livro removePrimeiro() {
        if (estaVazia())
            return null;
        Livro temp = pri.getInfo();
        pri = pri.getProximo();
        if (pri == null) {
            ult = null;
        } else {
            pri.setAnterior(null);
        }
        return temp;
    }

    public void insereFim(Livro livro) {
        NoDuplo temp = new NoDuplo(livro);
        if (estaVazia()) {
            pri = temp;
        } else {
            ult.setProximo(temp);
            temp.setAnterior(ult);
        }
        ult = temp;
    }

    public Livro removeUltimo() {
        if (estaVazia())
            return null;
        Livro temp = ult.getInfo();
        ult = ult.getAnterior();
        if (ult == null) {
            pri = null;
        } else {
            ult.setProximo(null);
        }
        return temp;
    }

    public Livro buscarPorIsbn(String isbn) {
        NoDuplo atual = pri;
        while (atual != null) {
            if (atual.getInfo().getIsbn().equals(isbn)) {
                return atual.getInfo();
            }
            atual = atual.getProximo();
        }
        return null;
    }

    public void listarDoInicio() {
        NoDuplo atual = pri;
        while (atual != null) {
            System.out.println(atual.getInfo());
            atual = atual.getProximo();
        }
    }

    public void listarDoFim() {
        NoDuplo atual = ult;
        while (atual != null) {
            System.out.println(atual.getInfo());
            atual = atual.getAnterior();
        }
    }

    public int tamanho() {
        NoDuplo atual = pri;
        int tamanho = 0;
        while (atual != null) {
            tamanho++;
            atual = atual.getProximo();
        }
        return tamanho;
    }
}