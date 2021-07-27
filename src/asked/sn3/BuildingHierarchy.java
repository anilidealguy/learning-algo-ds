package asked.sn3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildingHierarchy {

    public Entity buildHierarchy(List<Entity> list) {
        Entity root = null;

        Map<String, Entity> map = new HashMap<>();

        for(Entity e : list) {
            map.put(e.id, e);

            if (e.parentId == null)
                root = e;
        }

        if (root == null)
            return null;

        for(Entity e : list) {
            if (e.parentId != null) {
                map.get(e.parentId).children.add(e);
            }
        }

        root.label = "1.0";
        doDFS(root, "1");
        return root;
    }

    private void doDFS(Entity root, String label) {
        if (root.children.isEmpty()) {
            return;
        }

        for (int i = 0; i <root.children.size(); i++) {
            Entity child = root.children.get(i);
            child.label = label + "." + (i+1);
            doDFS(child, child.label);
        }
    }
}
