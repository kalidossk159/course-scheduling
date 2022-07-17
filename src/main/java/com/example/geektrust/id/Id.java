package com.example.geektrust.id;

public class Id<T> {

  T id;

  public Id(T id){
    this.id = id;
  }

  public T getId(){
    return id;
  }

  @Override
  public String toString() {
    return id.toString();
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if(obj instanceof Id){
      Id<T> anotherId = (Id<T>) obj;
      return id.equals(anotherId.getId());
    }
    return false;
  }
}
