package com.example.stephie.prueba;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Stephie on 18-10-2016.
 */

public class Animal {
    private int id;
    private String nombre;
    private int peso;
    private String dueno;

    public Animal(){}

    public Animal(Parcel parcel){
        id = parcel.readInt();
        nombre = parcel.readString();
        dueno = parcel.readString();
        peso = parcel.readInt();
    }

    public Animal(int id, String nombre,int peso, String dueno){
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
        this.dueno = dueno;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setPeso(int peso ){ this.peso = peso; }
    public int getPeso(){ return this.peso; }
    public void setDueno(String dueno) { this.dueno = dueno; }
    public String getDueno() { return dueno; }


    public int describeContents() {
        return 0;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(getId());
        dest.writeString(getNombre());
        dest.writeInt(getPeso());
        dest.writeString(getDueno());
    }
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };
}
