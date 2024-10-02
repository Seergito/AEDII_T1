/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aedii_t1;

/**
 *
 * @author estudante
 */
public class EnlazadoArbolBinario<E> implements ArbolBinario<E> {

    private NodoBinario<E> r;

    public EnlazadoArbolBinario() {
        r = null;
    }

    public EnlazadoArbolBinario(E raiz, ArbolBinario<E> hi, ArbolBinario<E> hd) {
        if (raiz == null || hi == null || hd == null) {
            r = null;
        }

        r = new NodoBinario<E>(raiz, ((EnlazadoArbolBinario<E>) hi).r, ((EnlazadoArbolBinario<E>) hi).r);

    }
    
     private EnlazadoArbolBinario(NodoBinario<E> raiz) {
        r = raiz;
    }

    @Override
    public boolean esVacio() {
        if (r == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public E raiz() throws ArbolVacioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArbolBinario<E> hijoIzq() throws ArbolVacioExcepcion {
        
        //CREAR UN CONSTRUCTOR PRIVADO EN EL QUE CREAMOS UN ARBOL_ENLAZADO_BINARIO CUYA RAIZ ES UN PARÁMETRO
        if(this.esVacio()){
            throw new ArbolVacioExcepcion();
        }
        return new EnlazadoArbolBinario<>(r.getIzq());
    }
    
    
    

    @Override
    public ArbolBinario<E> hijoDer() throws ArbolVacioExcepcion {
        if(this.esVacio()){
            throw new ArbolVacioExcepcion();
        }
        return new EnlazadoArbolBinario<>(r.getDer());
    }

    @Override
    public boolean esta(E elemento) {
        return esta(r,elemento);
    }
    
    private boolean esta(NodoBinario<E> raiz, E elemento){
  /*
              if(raiz.getElemento().equals(elemento)){
            return true;
        }else if(raiz.equals(null)){
            return false;
        }else if(esta(raiz.getIzq(),elemento)){
           return true;
        }else{
            return esta(raiz.getDer(), elemento);
        }
        */
        
        // METODO 2
        
        return (esta(raiz.getIzq(),elemento) || esta(raiz.getDer(),elemento));
        
    }
    

    @Override
    public void setRaiz(E elemRaiz) throws ArbolVacioExcepcion, NullPointerException {
        if (r != null && r.getElemento() != null) {
            r.setElemento(elemRaiz);
        } else {
            throw new ArbolVacioExcepcion();
        }

    }

    @Override
    public void setHijoIzq(ArbolBinario<E> hi) throws ArbolVacioExcepcion, NullPointerException {

        if (r != null && hi != null) {
            r.setIzq(((EnlazadoArbolBinario<E>) hi).r);
        }
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setHijoDer(ArbolBinario<E> hd) throws ArbolVacioExcepcion, NullPointerException {

        if (r != null && hd != null) {
            r.setIzq(((EnlazadoArbolBinario<E>) hd).r);
        }
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void suprimir() {
        r=null;
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
