package org.akee.prj22.school_management.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "classroom", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class ClassRoom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private boolean is_deleted;

	private boolean is_activated;

	public ClassRoom(String name) {
		this.name = name;
		this.is_activated = true;
		this.is_deleted = false;
	}

	public ClassRoom(ClassRoom classroom) {
		if (classroom.getId() != null) {
			this.id = classroom.getId();
		}
		this.name = classroom.name;
		this.is_activated = classroom.is_activated();
		this.is_deleted = classroom.is_deleted();
	}

}