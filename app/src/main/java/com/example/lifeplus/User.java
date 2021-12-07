package com.example.lifeplus;

public class User {
    public String store_name;
    public String category;
    public String store_address;

    public User(){

    }

    public User(String _storename, String _storeaddress/*, String _category*/){
        store_name = _storename;
        store_address = _storeaddress;
        //category = _category;
    }

    public String getStorename(){
        return store_name;
    }
    public void setStorename(String _storename){
        store_name = _storename;
    }

    public String getAddress(){
        return store_address;
    }
    public void setAddress(String _storeaddress){
        store_address = _storeaddress;
    }

    public String getCategory(){
        return category;
    }
    public void setCategory(String _category){
        category = _category;
    }

    @Override
    public String toString(){
        return "가맹점 : "+store_name+", "+"주소 : " + store_address; //+", "+"카테고리 : "+category
    }
}
