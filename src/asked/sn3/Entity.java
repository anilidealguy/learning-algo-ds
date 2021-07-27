package asked.sn3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Entity {
    public String id;
    public String parentId;
    public String name;
    public String description;
    public String label;
    public List<Entity> children = new ArrayList<>();

    public Entity(String id, String parentId, String name, String description, String label) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.description = description;
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return Objects.equals(id, entity.id) && Objects.equals(parentId, entity.parentId) && Objects.equals(name, entity.name) && Objects.equals(description, entity.description) && Objects.equals(label, entity.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, parentId, name, description, label);
    }
}
