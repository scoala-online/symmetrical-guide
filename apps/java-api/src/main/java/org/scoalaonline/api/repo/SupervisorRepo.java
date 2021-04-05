package org.scoalaonline.api.repo;

import org.scoalaonline.api.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupervisorRepo extends JpaRepository<Department, Long> {
}
