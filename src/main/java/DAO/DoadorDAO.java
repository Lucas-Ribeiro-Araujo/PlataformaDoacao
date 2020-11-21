/*
 Aqui vamos simular a persistência de dados.
 Nas próximas aulas nós vamos reprogramar esta classe para conectar-se com o banco de dados.
 */
package DAO;

import Model.Doador;
import java.util.*;

public class DoadorDAO {

    public static ArrayList<Doador> MinhaLista = new ArrayList<Doador>();

    public static int maiorID() {
        
        int maiorID = 0;
        for (int i = 0; i < MinhaLista.size(); i++) {
            if (MinhaLista.get(i).getId() > maiorID) {
                maiorID = MinhaLista.get(i).getId();
            }
        }
        return maiorID;
        
        
    }

}
