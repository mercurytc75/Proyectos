package github;

import java.util.*;

public class Problema7 {
    public void agregarNombres(List<String> lista){
        lista.add("ana");
        lista.add("ricoy");
        lista.add("ricoy");
    }
    public void mostrarLista(List<String> lista){
        System.out.println("\nLista de nombres : ");
        for (String n : lista) {
            System.out.println(n);
        }
    }
    public void agregarFrutas(Set<String> set){
        set.add("Manzana");
        set.add("Manzana");
        set.add("fresa");
    }
    public void mostrarSet(Set<String> set){
        System.out.println("\nSet de frutas(sin ser duplicados): ");
        for (String n : set) {
            System.out.println("- "+ n);
        }
    }
    public void agregarTareas(Queue<String> queue){
        queue.offer("imprimir archivo");
        queue.offer("enviar correo");
        queue.offer("guardar documento");
    }
    public void procesarCola(Queue<String> queue){
        System.out.println("\nprocesando cola de tareas: ");
        while (!queue.isEmpty()) { 
            String tarea = queue.poll();
            System.out.println("-> "+ tarea);
        }
    }
    public void agregarUsuarios(Map<String, Integer> map){
        map.put("mario", 30);
        map.put("lucia", 25);
    }
    public void mostrarMapa(Map<String, Integer> map){
        System.out.println("\nMapa de usuarios (Clave ->)");
        for (String n : map.keySet()) {
            System.out.println(n + " -> " + map.get(n) + " años");
        }
    }
    public static void main(String[] args){
        Problema7 pro = new Problema7();
        //1 - list - lista de nombres
        List<String> listDeNombres = new ArrayList<>();
        pro.agregarNombres(listDeNombres);
        pro.mostrarLista(listDeNombres);

        //2. set - Conjunto de frutas(sin diplicados)
        Set<String> conjuntoFrutas = new HashSet<>();
        pro.agregarFrutas(conjuntoFrutas);
        pro.mostrarSet(conjuntoFrutas);

        //3. Queue - Cola de tareas (FIFO)
        Queue<String> colaTareas = new LinkedList<>();
        pro.agregarTareas(colaTareas);
        pro.procesarCola(colaTareas);

        //4. Map - Mapa de usuarios y su edad
        Map<String, Integer> MapaUsuarios = new HashMap<>();
        pro.agregarUsuarios(MapaUsuarios);
        pro.mostrarMapa(MapaUsuarios);
    }
}
