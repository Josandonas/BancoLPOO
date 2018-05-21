

import bancotrabalholuciano.Pessoa;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Harrison
 */
public class ControllerPessoa {

    ArrayList<Pessoa> lista = new ArrayList<>();
    
    /**
     * m�todo para a cria��o de um array de Pessoas
     *
     * @param pessoas
     *
     */
    
    public  void criar(Pessoa pessoas) {

        lista.add(pessoas);

        
    }
    
    /**
     * Metodo do tipo boolean utilizado para fazer a remo��o de um usuario
     * @param id
     * @return 
     */

    
    public  boolean remove (Long id){
        
       for (Pessoa p : lista){
           if (Objects.equals(p.getId(), id)){
              return lista.remove(p);
           }
       } 
        return false;
        
        
    }

    /**
     *
     * Metodo do tipo pessoa utilizado para buscar pessoas da lista
     *
     * @param id
     * @return
     */
    public Pessoa busca(Long id) {

        for (Pessoa p : lista) {
            if (Objects.equals(p.getId(), id)) {
                return p;
            }

        }

        return null;

    }

   /*
    *
    *metodo para imprimir todas as pessoas da lista
    */
    
    public void mostra() {
        if (lista.isEmpty()) {
            System.out.println("Lista Vazia");
        } else {
            lista.forEach((p) -> {
                System.out.println(p);
            });
        }
    }

}
