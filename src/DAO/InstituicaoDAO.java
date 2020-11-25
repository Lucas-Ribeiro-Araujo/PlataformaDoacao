package DAO;

import Model.Instituicao;
import java.util.*;

public class InstituicaoDAO {

    public static ArrayList<Instituicao> MinhaLista = new ArrayList<Instituicao>();

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