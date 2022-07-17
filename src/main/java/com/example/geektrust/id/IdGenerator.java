package com.example.geektrust.id;

import java.util.Map;

public interface IdGenerator<T> {

  public Id<T> generateId(Map<IdGenerationKey, String> idGenerationData);

}
