package com.zencode.companiesdatarest.projections;

import java.time.LocalDateTime;

public interface BaseProjection {

    Long getId();

    LocalDateTime getCreatedAt();

    LocalDateTime getUpdatedAt();

    Long getVersion();

    LocalDateTime getLastModifiedDate();
}
