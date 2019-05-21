package pl.coderslab.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.coderslab.validator.TextValidationGroup;

@Entity
@Table(name = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 5)
	@NotNull(groups = TextValidationGroup.class)
	private String title;

	@ManyToMany(cascade = CascadeType.MERGE)
	@NotNull
	private List<Author> authors = new ArrayList<>();

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "publisher_id")
	@NotNull
	private Publisher publisher;
	@Size(max = 600, groups = TextValidationGroup.class)
	private String description;
	@Min(1)
	@Max(10)
	private int rating;
	@Min(2)
	private Integer pages;

	private Boolean proposition;

	@ManyToOne
	private Category category;

}
