package com.example.test.repository;

import com.example.test.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
    @Query(nativeQuery = true, value = "select * from task where idtask = ?")
    Task getById(int id);
    @Query(nativeQuery = true, value = "SELECT * FROM task where if (?1 is not null, lower(first_name) like concat(lower (?1), '%'), true)")
    Task search();

}
