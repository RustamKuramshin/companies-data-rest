package com.zencode.companiesdatarest.projections;

import java.time.LocalDateTime;
import java.util.UUID;

public interface BaseProjection {

    UUID getUuid();

    LocalDateTime getCreatedAt();

    LocalDateTime getUpdatedAt();

    Long getVersion();

    LocalDateTime getLastModifiedDate();
}
