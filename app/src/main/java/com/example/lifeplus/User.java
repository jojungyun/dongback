package com.example.lifeplus;

public class User {
    public String store_name;
    public String store_address;

    public User(){

    }

    public User(String _store_name, String _store_address){
        store_name = _store_name;
        store_address = _store_address;
    }

    public String getStore_name(){
        return store_name;
    }
    public void setStore_name(String _store_name){
        store_name = _store_name;
    }

    public String getStore_address(){
        return store_address;
    }
    public void setStore_address(String _store_address){
        store_address = _store_address;
    }

    @Override
    public String toString(){
        return "User{" + "store_name = " +store_name+", "+"store_address = " + store_address+"}";
    }
}
