import java.util.HashMap;
import java.util.Map;

public class ArmazemDeComida extends Armazem<Comida> {
    private Map<String, Comida> itens = new HashMap<>();

    public void adicionarAoInventario(String nome, Comida item) {
        itens.put(nome, item);
    }

    public Comida obterDoInventario(String nome) {
        return itens.get(nome);
    }

    @Override
    public void adicionar(Comida item) {
        itens.put(item.getNome(), item);
    }

    @Override
    public Comida obter(String nome) {
        return itens.get(nome);
    }
}
