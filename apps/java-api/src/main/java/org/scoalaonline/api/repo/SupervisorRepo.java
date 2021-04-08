package org.scoalaonline.api.repo;

import org.scoalaonline.api.model.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupervisorRepo extends JpaRepository<Supervisor, Long> {
}
