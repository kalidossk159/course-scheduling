package com.example.geektrust.id;

import java.util.Map;

public class StringIdGenerator implements IdGenerator<String> {

  @Override
  public Id<String> generateId(Map<IdGenerationKey, String> idGenerationData) {
      String prefix = idGenerationData.get(IdGenerationKey.PREFIX);
      String suffix = idGenerationData.get(IdGenerationKey.SUFFIX);

      return new Id<>(prefix + suffix);
  }
}
