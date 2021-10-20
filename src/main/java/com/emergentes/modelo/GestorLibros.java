package com.emergentes.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class GestorLibros {
    private ArrayList<Libros> lista;
    public GestorLibros() {
        lista = new ArrayList<Libros> ();
    }
    public ArrayList<Libros> getLista() {
        return lista;
    }
    public void setLista(ArrayList<Libros> lista) {
        this.lista = lista;
    }
    public void insertaLibro(Libros item){
        lista.add(item);
    }
    public void modificaLibro(int pos,Libros item){
        lista.set(pos, item);
    }
    public void eliminaLibro(int pos){
        lista.remove(pos);
    }
    public int buscaId(){
        int idaux=0;
        for (Libros item:lista) {
            idaux=item.getId();
        }
        return idaux+1;
    }
    public int buscaLibro(int id){
        int pos=-1;
        Iterator<Libros> it = lista.iterator();
        while(it.hasNext()){
            ++pos;
            Libros aux = it.next();
            if (aux.getId()==id) {
                break;
            }
        }
        return pos;
    }
}
