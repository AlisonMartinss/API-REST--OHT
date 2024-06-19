package crud.oht.service;

import crud.oht.service.JPAentity.Entity_Crud;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class paginationService {
    public List<Entity_Crud> pagination (List<Entity_Crud> list, int nPage,int nPerpage) {

        /**
         *
         *  'nPage': Se trata do numero da pagina que o user quer buscar.
         *  'nPerpage': Se trata do numero de elementos por pagina.
         *  'n': Se trata de um parametro que ajuda a colocar somente os elementos nescessários na lista de suporte.
         *
         * **/

        int xPage = nPage;
        int n = nPerpage*nPage - nPerpage;

        List<Entity_Crud> listasuporte  = new ArrayList<>();

        if (nPage*nPerpage > list.size()){


            int parametroA = (nPage*nPerpage) - list.size();
            int parametroB = ((nPage*nPerpage) - parametroA) - 1;

            int sivirino = (nPage*nPerpage) - parametroA - (nPerpage * (nPage - 1));


            n = parametroB  - sivirino;


            for (int i = parametroB ; i > n; i--){

                if (list.get(i) != null){

                    listasuporte.add(list.get(i));

                }}

            Collections.reverse(listasuporte);

            return listasuporte;

        }

        else {

            for (int i = (nPage * nPerpage) - 1 ; i > n-1; i--){


                if (list.get(i) != null){

                    listasuporte.add(list.get(i));

                }}

            Collections.reverse(listasuporte);

            return listasuporte;

        }

    }}
