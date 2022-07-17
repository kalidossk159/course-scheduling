package com.example.geektrust.datastore;

import com.example.geektrust.entity.Entity;
import com.example.geektrust.entity.EntityType;
import com.example.geektrust.id.Id;
import java.util.List;

public interface DataStore {

  public Entity<?> insert(Entity<?> entity);

  public Entity<?> update(Entity<?> entity);

  public Entity<?> find(Id<?> id, EntityType entityType);

  public List<Entity<?>> list(EntityType entityType);

}
