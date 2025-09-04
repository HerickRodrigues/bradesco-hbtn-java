import java.util.HashMap;
import java.util.Map;

public class ArmazemDeEletronico extends Armazem<Eletronico> {
    private Map<String, Eletronico> itens = new HashMap<>();

    public void adicionarAoInventario(String nome, Eletronico item) {
        itens.put(nome, item);
    }

    public Eletronico obterDoInventario(String nome) {
        return itens.get(nome);
    }

    @Override
    public void adicionar(Eletronico item) {
        itens.put(item.getDescricao(), item);
    }

    @Override
    public Eletronico obter(String nome) {
        return itens.get(nome);
    }
}
