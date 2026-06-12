public class NossoHash<K, V> {
    private Entrada<K, V>[] tabela;
    private static final int CAP_INICIAL = 16;

    @SuppressWarnings("unchecked")
    public NossoHash() {
        tabela = new Entrada[CAP_INICIAL];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % CAP_INICIAL;
    }

    public void put(K key, V value) {
        int i = hash(key);
        Entrada<K, V> novo = new Entrada<>(key, value);
        novo.proximo = tabela[i];
        tabela[i] = novo;
    }

    public V get(K key) {
        int i = hash(key);
        Entrada<K, V> p = tabela[i];
        while (p != null) {
            if (p.key.equals(key))
                return p.value;
            p = p.proximo;
        }
        return null;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public boolean containsValue(V value) {
        for (int i = 0; i < tabela.length; i++) {
            Entrada<K, V> p = tabela[i];
            while (p != null) {
                if (p.value.equals(value))
                    return true;
                p = p.proximo;
            }
        }
        return false;
    }

    public void exibeMap() {
        for (int i = 0; i < tabela.length; i++) {
            System.out.print(i + ": ");
            Entrada<K, V> p = tabela[i];
            if (p == null) {
                System.out.println("[]");
                continue;
            }
            while (p != null) {
                System.out.print("(" + p.key + " => " + p.value + ") -> ");
                p = p.proximo;
            }
            System.out.println("null");
        }
    }
}
