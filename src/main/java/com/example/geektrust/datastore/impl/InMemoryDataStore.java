package com.example.geektrust.datastore.impl;

import com.example.geektrust.datastore.DataStore;
import com.example.geektrust.entity.Entity;
import com.example.geektrust.entity.EntityType;
import com.example.geektrust.id.Id;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryDataStore implements DataStore {

  private static InMemoryDataStore instance;
  Map<EntityType, Map<Id<?>, Entity<?>>> dataStore;

  private InMemoryDataStore(){
    dataStore = new HashMap<>();
    for(EntityType value : EntityType.values()){
      dataStore.put(value, new HashMap<>());
    }
  }

  public static InMemoryDataStore getInstance(){
    if(instance == null)
      instance = new InMemoryDataStore();
    return instance;
  }

  @Override
  public Entity<?> insert(Entity<?> entity) {
    Map<Id<?>, Entity<?>> entityMap = dataStore.get(entity.getEntityType());
    entityMap.put(entity.getId(), entity);
    return entity;
  }

  @Override
  public Entity<?> update(Entity<?> entity) {
    return insert(entity);
  }

  @Override
  public Entity<?> find(Id<?> id, EntityType entityType) {
    Map<Id<?>, Entity<?>> entityMap = dataStore.get(entityType);
    return entityMap.get(id);
  }

  @Override
  public List<Entity<?>> list(EntityType entityType) {
    Map<Id<?>, Entity<?>> entityMap = dataStore.get(entityType);
    return new ArrayList<>(entityMap.values());
  }
}
