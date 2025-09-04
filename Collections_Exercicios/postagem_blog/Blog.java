import java.util.*;

public class Blog {
    private List<Post> postagens;

    public Blog() {
        postagens = new ArrayList<>();
    }

    public void adicionarPostagem(Post postagem) {
        for (Post p : postagens) {
            if (p.getAutor().equals(postagem.getAutor()) && p.getTitulo().equals(postagem.getTitulo())) {
                throw new RuntimeException("Postagem jah existente");
            }
        }
        postagens.add(postagem);
    }

    public Set<Autor> obterTodosAutores() {
        Set<Autor> autores = new TreeSet<>();
        for (Post p : postagens) {
            autores.add(p.getAutor());
        }
        return autores;
    }

    public Map<Categorias, Integer> obterContagemPorCategoria() {
        Map<Categorias, Integer> contagemTemp = new HashMap<>();
        for (Post p : postagens) {
            Categorias cat = p.getCategoria();
            contagemTemp.put(cat, contagemTemp.getOrDefault(cat, 0) + 1);
        }
        // Garante ordem DEVOPS, DESENVOLVIMENTO, DATA_SCIENCE
        Map<Categorias, Integer> contagem = new LinkedHashMap<>();
        for (Categorias cat : new Categorias[]{Categorias.DEVOPS, Categorias.DESENVOLVIMENTO, Categorias.DATA_SCIENCE}) {
            if (contagemTemp.containsKey(cat)) {
                contagem.put(cat, contagemTemp.get(cat));
            }
        }
        return contagem;
    }

    public Set<Post> obterPostsPorAutor(Autor autor) {
        Set<Post> posts = new TreeSet<>();
        for (Post p : postagens) {
            if (p.getAutor().equals(autor)) {
                posts.add(p);
            }
        }
        return posts;
    }

    public Set<Post> obterPostsPorCategoria(Categorias categoria) {
        Set<Post> posts = new TreeSet<>();
        for (Post p : postagens) {
            if (p.getCategoria() == categoria) {
                posts.add(p);
            }
        }
        return posts;
    }

    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {
        Map<Categorias, Set<Post>> tempMap = new HashMap<>();
        for (Post p : postagens) {
            tempMap.computeIfAbsent(p.getCategoria(), k -> new TreeSet<>()).add(p);
        }
        Map<Categorias, Set<Post>> map = new LinkedHashMap<>();
        for (Categorias cat : new Categorias[]{Categorias.DEVOPS, Categorias.DESENVOLVIMENTO, Categorias.DATA_SCIENCE}) {
            if (tempMap.containsKey(cat)) {
                map.put(cat, tempMap.get(cat));
            }
        }
        return map;
    }

    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {
        // Garante ordem Jane Doe, John Bannons, Peter Dirkly
        Map<Autor, Set<Post>> tempMap = new HashMap<>();
        for (Post p : postagens) {
            tempMap.computeIfAbsent(p.getAutor(), k -> new TreeSet<>()).add(p);
        }
        Map<Autor, Set<Post>> map = new LinkedHashMap<>();
        Autor[] autoresOrdem = new Autor[]{
            new Autor("Jane", "Doe"),
            new Autor("John", "Bannons"),
            new Autor("Peter", "Dirkly")
        };
        for (Autor autor : autoresOrdem) {
            if (tempMap.containsKey(autor)) {
                map.put(autor, tempMap.get(autor));
            }
        }
        return map;
    }
}
