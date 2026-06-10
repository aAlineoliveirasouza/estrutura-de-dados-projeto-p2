public class Fila<T> {
    private No<T> pri;
    private No<T> ult;

    public void enfileira(T info) {
        No<T> n = new No<>(info);
        ult.setProximo(n);
        ult = n;
    }

    public T desenfileira() throws FilaVaziaException {
        if (pri == null)
            throw new FilaVaziaException("Fila vazia");
        T v = pri.getInfo();
        pri = pri.getProximo();
        if (pri == null)
            ult = null;
        return v;
    }

    public T pri() {
        return pri == null ? null : pri.getInfo();
    }

    public boolean filaVazia() {
        return pri == null;
    }

    public int tamanho() {
        int count = 0;
        No<T> p = pri;
        while (p != null) {
            count++;
            p = p.getProximo();
        }
        return count;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        No<T> p = pri;
        while (p != null) {
            sb.append(p.getInfo()).append("->");
            p = p.getProximo();
        }
        sb.append("\\");
        return sb.toString();
    }
}

class FilaVaziaException extends Exception {
    public FilaVaziaException(String msg) {
        super(msg);
    }
}
