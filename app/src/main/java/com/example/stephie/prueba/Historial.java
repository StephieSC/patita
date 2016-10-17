package com.example.stephie.prueba;

/**
 * Created by Stephie on 16-10-2016.
 */
public class Historial {
        private int nivel;
        private String fecha;
        private int logrado;// 1 si 0 no

        public Historial(int nivel, String fecha, int logrado) {
            this.nivel = nivel;
            this.fecha = fecha;
            this.logrado= logrado;
        }

        public String getfecha() {
            return fecha;
        }

        public int getLogrado() {
            return logrado;
        }

        public int getNivel() {
            return nivel;
        }
        public void setNivel(int nivel){
            this.nivel = nivel;
        }
        public void setFecha(String fecha){
            this.fecha = fecha;
        }
    public void setLogrado(int logrado){
        this.logrado = logrado;
    }

}
