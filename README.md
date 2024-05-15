# JPASeries
In Java Persistence API (JPA), annotations are employed to establish relationships between entities (classes representing database tables). These annotations streamline the process of defining how entities interact with each other, ensuring data consistency and simplifying queries.

## Key Relationship Mappings:

 1. **@OneToOne (One-to-One):**
  - Represents a unidirectional or bidirectional association between two entities, where one entity instance can be associated with at most one instance of another entity.
  - Example: A Customer entity might have a @OneToOne relationship with an Address entity, indicating that a customer can have only one primary address.

 2. **@OneToMany (One-to-Many):**
  - Models a unidirectional or bidirectional relationship between an entity and a collection of another entity. One entity instance can be associated with multiple instances of another entity.
  - Example: An Order entity might have a @OneToMany relationship with an OrderItem entity, signifying that an order can have many order items.

 3. **@ManyToOne (Many-to-One):**
  - Represents the inverse of @OneToMany. Multiple entity instances can be associated with a single instance of another entity.
  - Example: An OrderItem entity (from the previous example) might have a @ManyToOne relationship with the Order entity, indicating that an order item belongs to a specific order.

 4. **@ManyToMany (Many-to-Many):**
  - Captures a bidirectional relationship where multiple entity instances can be associated with multiple instances of another entity. A separate join table is typically used to manage the associations.
  - Example: A Course entity might have a @ManyToMany relationship with a Student entity, signifying that a student can enroll in multiple courses, and a course can have multiple students enrolled in it.

## Common Considerations:

- **Uni/Bidirectional Relationships:** Decide whether the relationship should be unidirectional (managed by one entity) or bidirectional (managed by both entities).
- **Cascade Operations (Optional):** Specify how persistence operations (save, update, delete) on one entity should cascade to the related entity(ies).
- **JoinColumn/JoinTable:** For @OneToOne and @ManyToOne, use @JoinColumn to define the column(s) in the target entity that hold the foreign key(s). For @ManyToMany, use @JoinTable to specify the join table and its columns.
