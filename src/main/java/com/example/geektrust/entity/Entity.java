package com.example.geektrust.entity;

import com.example.geektrust.id.Id;
import com.example.geektrust.id.IdGenerationKey;
import com.example.geektrust.id.IdGenerator;
import java.util.Map;

public abstract class Entity<T> {

  EntityType entityType;

  Id<T> id;

  IdGenerator<T> idGenerator;

  public Entity(EntityType entityType, IdGenerator<T> idGenerator){
    this.entityType = entityType;
    this.idGenerator = idGenerator;
  }

  public  EntityType getEntityType(){
    return this.entityType;
  }

  public  Id<T> getId(){
    if(id == null){
      id = generateId();
    }
    return this.id;
  }

  private Id<T> generateId(){
    Map<IdGenerationKey, String> idGenerationData = getIdGenerationData();
    return idGenerator.generateId(idGenerationData);
  }

  public abstract Map<IdGenerationKey, String> getIdGenerationData();

}
